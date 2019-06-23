import java.util.Scanner;

class IceCreamVendingMachine{

	private static States[] stateList = new States[4];


	/*
		Init our class, i.e load states
	*/
		private static void init(){

			/*
				Create states
			*/

			//start state
			States startState = new States();
			startState.paidAmnt = 0;
			startState.input1 = 20;
			startState.input2 = 40;
			startState.nextState1 = 1;
			startState.nextState2 = 2;
			startState.isAccept = false;
			stateList[0] = startState;

			//first state
			States state1 = new States();
			state1.paidAmnt = 20;
			state1.input1 = 20;
			state1.input2 = 40;
			state1.nextState1 = 2;
			state1.nextState2 = 3;
			state1.isAccept = false;
			stateList[1] = state1;

			//second state
			States state2 = new States();
			state2.paidAmnt = 40;
			state2.input1 = 20;
			state2.input2 = 20;
			state2.nextState1 = 3;
			state2.nextState2 = 3;
			state2.isAccept = false;
			stateList[2] = state2;

			//third and final state
			States state3 = new States();
			state3.paidAmnt = 60;
			state3.input1 = 0;
			state3.input2 = 0;
			state3.nextState1 = 3;
			state3.nextState2 = 3;
			state3.isAccept = true;
			stateList[3] = state3;

		}


		//Run our machine
		private static void runMachine(){

			//handle our looping, representative of state
			int counter = 0;

			//save user input
			int userInput;

			Scanner input = new Scanner(System.in);

			//3 cause never loop through accept state
			while (counter < stateList.length){


				//do somtin
				//get user input
				userInput = input.nextInt();
				if (stateList[counter].input1 == userInput || stateList[counter].input2 == userInput){

					//If next is accept state, stop machine
					if (stateList[transitionState(counter, userInput)].isAccept){

						System.out.println("Please take your ice cream from the bin");
						break;
					}
					//move to next state
					counter = stateList[counter].input1 == userInput ? stateList[counter].nextState1 : stateList[counter].nextState2;
				} else{

					//show error
					System.out.println("Please enter either a ksh " + stateList[counter].input1 + " coin or a ksh" + stateList[counter].input1 + " coin");
				}
			}
		}

		private static int transitionState(int counter, int userInput){

			return stateList[counter].input1 == userInput ? stateList[counter].nextState1 : stateList[counter].nextState2;

		}

		public static void main(String[] args){

			init();
			runMachine();
			//System.out.println("Okay, state1 input1 " + String.valueOf(stateList[0].input1));
		}


	private static class States{

		int paidAmnt;
		int input1, input2;
		int nextState1, nextState2;
		boolean isAccept;

	}
}