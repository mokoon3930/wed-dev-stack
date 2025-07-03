package view;

import controller.PersonController;

public class PersonView {
	
	
	
	public static void main(String[] args) {
		PersonController pc = new PersonController();
		
		//pc.addPerson();
		//pc.searchAllPerson();
		//pc.searchPerson();
		//pc.updatePerson();
		pc.removePerson();
		//테스트 용도
	}

}
