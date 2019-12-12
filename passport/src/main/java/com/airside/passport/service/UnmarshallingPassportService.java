package com.airside.passport.service;

import org.springframework.stereotype.Service;

import com.airside.passport.constants.PassportConstants;

@Service
public class UnmarshallingPassportService {

	/**
	 * @param passportBody
	 * @return String value of Surname + given names
	 */
	public String mainUnmarshallingPassportService(String passportBody) {

		StringBuilder output = new StringBuilder();
		String surnamePlaceHolder = null;

		if (passportBody != null && !passportBody.isEmpty() && passportBody.length() <= 88) {

			char[] passportBodyInArr = passportBody.toCharArray();
			int arrStartHolder = 5;

			// Getting the Surname from the loop
			for (int i = 5; i < passportBodyInArr.length; i++) {

				if (passportBodyInArr[i] == PassportConstants.ONE_FILLER) {

					arrStartHolder = i;
					output.append(PassportConstants.EMPTY_SINGE_SPACE);
					break;

				} else {

					output.append(passportBodyInArr[i]);
				}
			}

			surnamePlaceHolder = PassportConstants.EMPTY_SINGE_SPACE + output.toString();

			// Checking to make sure that next two from the passportBodyInArr are two
			// fillers
			if (passportBodyInArr[arrStartHolder] == PassportConstants.ONE_FILLER
					&& passportBodyInArr[arrStartHolder + 1] == PassportConstants.ONE_FILLER) {

				// as per the rule we are skipping the two fillers: followed by two filler
				// characters, followed by given names.
				for (int i = arrStartHolder + 2; i < passportBodyInArr.length; i++) {

					if (passportBodyInArr[i] == PassportConstants.ONE_FILLER
							&& passportBodyInArr[i + 1] == PassportConstants.ONE_FILLER) {

						break;

					} else if (passportBodyInArr[i] == PassportConstants.ONE_FILLER) {

						output.append(PassportConstants.EMPTY_SINGE_SPACE);

					} else {

						output.append(passportBodyInArr[i]);
					}
				}
			}
		}

		output.delete(0, output.indexOf(PassportConstants.EMPTY_SINGE_SPACE));
		output.append(surnamePlaceHolder);

		return output.toString().trim();
	}

}
