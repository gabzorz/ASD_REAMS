import java.util.ArrayList;

public class Calculator {

	ArrayList<Double> numbers;
	ArrayList<Character> operators;
	double answer = 0;
	int index;
	double tempAnswer = 0;

	// Get arrays from ToArray
	public Calculator(ToArray trans) {
		numbers = trans.numbers;
		operators = trans.operators;
	}

	// Main calculation method
	public double runCalc() {
		dotCalc();
		lineCalc();
		answer = numbers.get(0);
		return answer;
	}
	
	

	// First do multiplication and division
	public void dotCalc() {
		int indexMult = -1;
		int indexDiv = -1;
		// While both are present, check which comes first
		while ((indexMult = operators.indexOf('*')) != -1  && (indexDiv = operators.indexOf('/')) != -1) {

			if (indexMult < indexDiv) {
				index = indexMult;
				tempAnswer = numbers.get(index) * numbers.get(index + 1);
				changeArrays();
			} else if (operators.indexOf('/') < operators.indexOf('*')) {
				index = operators.indexOf('/');
				tempAnswer = numbers.get(index) / numbers.get(index + 1);
				changeArrays();
			}

		}
		// If only one exists in the calculation, do that one before addition and subtraction
		while ((indexMult = operators.indexOf('*')) != -1) {
			index = indexMult;
			tempAnswer = numbers.get(index) * numbers.get(index + 1);
			changeArrays();
		}

		while ((indexDiv = operators.indexOf('/')) != -1) {
			index = indexDiv;
			tempAnswer = numbers.get(index) / numbers.get(index + 1);
			changeArrays();
		}

	}

	// Then addition and subtraction
	public void lineCalc() {
		int indexAdd = -1;
		int indexSub = -1;
		// Check if both exist in the array and if they do, which one comes first
		while ((indexAdd = operators.indexOf('+')) != -1  && (indexSub = operators.indexOf('-')) != -1) {

			if (indexAdd < indexSub) {
				index = indexAdd;
				tempAnswer = numbers.get(index) + numbers.get(index + 1);
				changeArrays();
			} else if (operators.indexOf('-') < operators.indexOf('+')) {
				index = indexSub;
				tempAnswer = numbers.get(index) - numbers.get(index + 1);
				changeArrays();
			}

		}
		// If only one exists, do that one
		while ((indexAdd = operators.indexOf('+')) != -1) {
			index = indexAdd;
			tempAnswer = numbers.get(index) + numbers.get(index + 1);
			changeArrays();
		}

		while ((indexSub = operators.indexOf('-')) != -1) {
			index = indexSub;
			tempAnswer = numbers.get(index) - numbers.get(index + 1);
			changeArrays();
		}

	}
	
	public void changeArrays () {
		operators.remove(index);
		numbers.remove(index);
		numbers.remove(index);
		numbers.add(index, tempAnswer);
		tempAnswer = 0;
	}
	
}