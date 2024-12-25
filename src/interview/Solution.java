package interview;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * Given a flat file of book metadata, write a Library class that parses the book data and provides an API that lets you search for all books containing a word.
 *
 * Your solution must have a runtime of faster than O(n), with n representing the number of words in the library.
 *
 *  API:
 *
 *  Library
 *    - <constructor>(input) -> returns a Library object
 *    - search(word) -> returns all books that contain the word anywhere in the title, author, or description fields. Only matches *whole* words.
 *   E.g. Searching for "My" or "book" would match a book containing "My book", but searching for "My b" or "boo" would *not* match.
 */

class Library {
	String input = null;
	List<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
	Library(String input) {
		this.input = input;
		String[] words = input.split("\n\n");
		
		for (int i = 0; i < words.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			String books = words[i];

			/**
			 * "TITLE: Hitchhiker's Guide to the Galaxy\n" + "AUTHOR: Douglas Adams\n" +
			 * "DESCRIPTION: Seconds before the Earth is demolished to make way for a
			 * galactic freeway,\n" + "Arthur Dent is plucked off the planet by his friend
			 * Ford Prefect, a researcher for the\n" + "revised edition of The Hitchhiker's
			 * Guide to the Galaxy who, for the last fifteen years,\n" + "has been posing as
			 * an out-of-work actor.
			 **/
			String[] book = books.split("\n");
			String title = book[0];
			String author = book[1];
			String description = book[2];
			/// "TITLE: Hitchhiker's Guide to the Galaxy\n" +
			for (int j = 2; j < book.length; j++) {
				description = description + book[j];

			}

			String[] titleNames = title.split(":");
			String[] authorNames = author.split(":");
			String[] descriptionNames = description.split(":");

			map.put(titleNames[0], titleNames[1]);
			map.put(authorNames[0], authorNames[1]);
			map.put(authorNames[0], authorNames[1]);

			bookList.add(map);

		}

		
	}

	public String search(String[] words) {

		return "";
	}

}

class Solution {
	public static void main(String[] args) {
		Library library = new Library("TITLE: Hitchhiker's Guide to the Galaxy\n" + "AUTHOR: Douglas Adams\n"
				+ "DESCRIPTION: Seconds before the Earth is demolished to make way for a galactic freeway,\n"
				+ "Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the\n"
				+ "revised edition of The Hitchhiker's Guide to the Galaxy who, for the last fifteen years,\n"
				+ "has been posing as an out-of-work actor.\n" + "\n" + "TITLE: Dune\n" + "AUTHOR: Frank Herbert\n"
				+ "DESCRIPTION: The troubles begin when stewardship of Arrakis is transferred by the\n"
				+ "Emperor from the Harkonnen Noble House to House Atreides. The Harkonnens don't want to\n"
				+ "give up their privilege, though, and through sabotage and treachery they cast young\n"
				+ "Duke Paul Atreides out into the planet's harsh environment to die. There he falls in\n"
				+ "with the Fremen, a tribe of desert dwellers who become the basis of the army with which \n"
				+ "he will reclaim what's rightfully his. Paul Atreides, though, is far more than just a\n"
				+ "usurped duke. He might be the end product of a very long-term genetic experiment\n"
				+ "designed to breed a super human; he might be a messiah. His struggle is at the center\n"
				+ "of a nexus of powerful people and events, and the repercussions will be felt throughout\n"
				+ "the Imperium.\n" + "\n" + "TITLE: A Song Of Ice And Fire Series\n" + "AUTHOR: George R.R. Martin\n"
				+ "DESCRIPTION: As the Seven Kingdoms face a generation-long winter, the noble Stark family\n"
				+ "confronts the poisonous plots of the rival Lannisters, the emergence of the\n"
				+ "White Walkers, the arrival of barbarian hordes, and other threats.\n");

	/**	List<String> first_results = library.search("Arrakis");
		System.out.println(first_results.contains("Dune"));

		List<String> second_results = library.search("winter");
		System.out.println(second_results.contains("A Song Of Ice And Fire Series"));

		List<String> third_results = library.search("demolished");
		System.out.println(third_results.contains("Hitchhiker's Guide to the Galaxy"));

		List<String> fourth_results = library.search("the");
		System.out.println(fourth_results.size() == 3);
		System.out.println(fourth_results.contains("Dune"));
		System.out.println(fourth_results.contains("A Song Of Ice And Fire Series"));
		System.out.println(fourth_results.contains("Hitchhiker's Guide to the Galaxy"));**/
	}
} 