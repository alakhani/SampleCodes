package expressionParser;

/*Sample expression parser for addition and subtraction operations
 * Author: Aamin Lakhani
 * 
 */
public class ExpressionParser {

	private static void evaluate(String expression) {
		int len = expression.length();
		int i = 0;
		
		//get the first operand
		Wrapper w = getOperand(i, expression);
		String operand1 = w.getOperand();
		i = w.getIndex();
		while (i < len) {
			//get the operation
			char operator  = expression.charAt(i);
			i++;
			String operand2 = "";
			if (i < len) {
				Wrapper w1  = getOperand(i, expression);
				operand2 = w1.getOperand();
				i = w1.getIndex();
			}
			
			if (operator == '+') {
				operand1 = String.valueOf(Integer.parseInt(operand1) + Integer.parseInt(operand2));
			} else if (operator == '-') {
				operand1 = String.valueOf(Integer.parseInt(operand1) - Integer.parseInt(operand2));;
			}
		}
		System.out.println(operand1);
	}
	
	private static Wrapper getOperand(int index, String expression) {
		StringBuilder operand = new StringBuilder();
		int i = index;
		for (i = index; i < expression.length(); i++) {
			if (expression.charAt(i) != '(' && expression.charAt(i) != ')' && expression.charAt(i) != ' ') {
				if (expression.charAt(i) != '+' && expression.charAt(i) != '-') {
					operand.append(expression.charAt(i));
				} else {
					break;
				}
			}
			
		}
		Wrapper w = new Wrapper(i, operand.toString());
		return w;
	}
	
	public static void main(String args[]) {
		evaluate("((3+1)- 3)");
	}

}

