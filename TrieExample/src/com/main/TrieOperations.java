package com.main;

import java.util.Scanner;

public class TrieOperations {

	private static TrieNode rootNode = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TrieOperations operations = new TrieOperations();
		processRequest(sc, operations);
	}

	private static void processRequest(Scanner sc, TrieOperations operations) {
		System.out.println("Which operation do you want to do?");
		String operationSelected = sc.next();

		if (operationSelected.equalsIgnoreCase("Insert")) {
			doInsert(sc, operations);
		} else if (operationSelected.equalsIgnoreCase("Search")) {
			if(rootNode == null){
				System.out.println("No data in the Trie. Please insert a String first...");
				doInsert(sc, operations);
			} else {
				doSearch(sc, operations);
			}
		} else if (operationSelected.equalsIgnoreCase("Delete")) {
			if(rootNode == null){
				System.out.println("No data in the Trie. Please insert a String first...");
				doInsert(sc, operations);
			} else {
				doDelete(sc, operations);
			}
		}
		System.out.println("Do you want to continue? Y/N");
		String doContinue = sc.next();

		if (doContinue.equalsIgnoreCase("Y")) {
			processRequest(sc, operations);
		}
	}
	
	private static void doDelete(Scanner sc, TrieOperations operations) {
		System.out.println("Enter the String you want to delete :");
		String deleteString = sc.next();
		
		if(!deleteString.equals("")){
				boolean outCome = operations.delete(deleteString);
			if (outCome) {
				System.out.println("String deleted successfully.");
			} else {
				System.out.println("The string is not present, hence can't be deleted...");
			}
		}
	}

	private boolean delete(String deleteString) {
		boolean outCome = false;
		TrieNode currentNode = rootNode;
		
		for(int i=0; i<deleteString.length(); i++){
			if(!currentNode.getCharChild().containsKey(deleteString.charAt(i))){
				break;
			} else{
				currentNode = currentNode.getCharChild().get(deleteString.charAt(i));
				if(i == deleteString.length()-1 && currentNode.isEndOfString()){
					if(!currentNode.getCharChild().isEmpty()){
						currentNode.setEndOfString(false);
					} else{
						cascadingDeleteNode(currentNode, deleteString);
					}
					outCome = true;
				}
			}
		}
		return outCome;
	}

	private void cascadingDeleteNode(TrieNode currentNode, String deleteString) {
		for(int i=deleteString.length()-1; i >= 0; i--){
			if (currentNode.getCharChild().isEmpty()) {
				TrieNode root = currentNode.getRootNode();
				root.getCharChild().remove(deleteString.charAt(i));
				currentNode = root;
			} else{
				break;
			}
		}
		if(rootNode.getCharChild().isEmpty()){
			rootNode = null;
		}
	}

	private static void doSearch(Scanner sc, TrieOperations operations) {
		System.out.println("Enter which search do you want? 1. Prefix search;  2. Whole word search.");
		String searchOptionSelected = sc.next();
		
		if(searchOptionSelected.contains("Prefix")){
			System.out.println("Enter prefix of the search word :");
			String prefix = sc.next();
			boolean outcome = operations.prefixSearch(prefix);
			if(outcome == true){
				System.out.println("There is at least 1 string with prefix : " + prefix);
			} else{
				System.out.println("No String present with this prefix.");
			}
		} else if(searchOptionSelected.contains("Whole")){
			System.out.println("Enter whole word to search:");
			String wholeWord = sc.next();
			boolean outcome = operations.wholeWordSearch(wholeWord);
			if(outcome == true){
				System.out.println("This word is present.");
			} else{
				System.out.println("This String is not present.");
			}
		}
	}

	private static void doInsert(Scanner sc, TrieOperations operations) {
		System.out.println("Enter the String to insert:");
		String input = sc.next();
		
		if(input.length() != 0){
			if(rootNode == null){
				rootNode = new TrieNode(null);
			}
			try{
				operations.insert(input);
			}
			catch(Exception e){
				System.out.println("Insert failed due to : " + e.getMessage());
			}
		} else{
			System.out.println("Empty String...");
		}
		System.out.println("String Entered Successfully...");
	}

	private void insert(String input) {
		TrieNode currentNode = rootNode;
		
		for(int i=0; i<input.length(); i++){
			if(!currentNode.getCharChild().containsKey(input.charAt(i))){
				currentNode.getCharChild().put(input.charAt(i), new TrieNode(currentNode));
			} 
			currentNode = currentNode.getCharChild().get(input.charAt(i));
			if(i == input.length()-1){
				currentNode.setEndOfString(true);
			}
		}
	}

	private boolean prefixSearch(String prefix) {
		boolean outcome = false;
		TrieNode currentNode = rootNode; 
		
		for(int i=0; i<prefix.length(); i++){
			if(!currentNode.getCharChild().containsKey(prefix.charAt(i))){
				break;
			} else{
				currentNode = currentNode.getCharChild().get(prefix.charAt(i));
				if(i == prefix.length()-1){
					outcome = true;
				}
			}
		}
		return outcome;
	}
	
	private boolean wholeWordSearch(String wholeWord) {
		boolean outcome = false;
		TrieNode currentNode = rootNode; 
		
		for(int i=0; i<wholeWord.length(); i++){
			if(!currentNode.getCharChild().containsKey(wholeWord.charAt(i))){
				break;
			} else{
				currentNode = currentNode.getCharChild().get(wholeWord.charAt(i));
				if(i == wholeWord.length()-1 && currentNode.isEndOfString()){
					outcome = true;
				}
			}
		}
		return outcome;
	}
}
