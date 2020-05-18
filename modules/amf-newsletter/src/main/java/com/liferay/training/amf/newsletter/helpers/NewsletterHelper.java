package com.liferay.training.amf.newsletter.helpers;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The NewsletterHelper class implements helper methods for the newsletter
 * portlet.
 */
public class NewsletterHelper {

	/**
	 * The formatCreateDate method takes a java.util.Date as input and returns the
	 * date with the following format "MMMM dd, yyyy", e.g. (June 01, 2020).
	 */
	public static String formatCreateDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		String formattedDate = formatter.format(date);
		return formattedDate;
	}

	/**
	 * The mapYearToMonthToFolders takes a Map of Years (Integers) to List of
	 * JournalFolder Objects and returns a Map of Years (Integers) to Months
	 * (Integers) to Journal Folder Objects.
	 */
	public static Map<Integer, Map<Integer, List<JournalFolder>>> getYearToMonthToFolders(
			Map<Integer, List<JournalFolder>> yearsToFolders) {
		Map<Integer, Map<Integer, List<JournalFolder>>> yearToMonthToFolders = new HashMap<>();
		// map years of release to months of release to folders
		for (Integer year : yearsToFolders.keySet()) {
			yearToMonthToFolders.put(year, new HashMap<>());
			yearToMonthToFolders.get(year).put(0, new ArrayList<>());
			yearToMonthToFolders.get(year).put(1, new ArrayList<>());
			yearToMonthToFolders.get(year).put(2, new ArrayList<>());
			yearToMonthToFolders.get(year).put(3, new ArrayList<>());
			yearToMonthToFolders.get(year).put(4, new ArrayList<>());
			yearToMonthToFolders.get(year).put(5, new ArrayList<>());
			yearToMonthToFolders.get(year).put(6, new ArrayList<>());
			yearToMonthToFolders.get(year).put(7, new ArrayList<>());
			yearToMonthToFolders.get(year).put(8, new ArrayList<>());
			yearToMonthToFolders.get(year).put(9, new ArrayList<>());
			yearToMonthToFolders.get(year).put(10, new ArrayList<>());
			yearToMonthToFolders.get(year).put(11, new ArrayList<>());

			if (yearsToFolders.get(year) != null) {
				List<JournalFolder> journalFoldersOfYear = yearsToFolders.get(year);
				for (JournalFolder journalFolderOfYear : journalFoldersOfYear) {
					int monthNum = journalFolderOfYear.getCreateDate().getMonth();
					yearToMonthToFolders.get(year).get(monthNum).add(journalFolderOfYear);
				}
			}
		}
		return yearToMonthToFolders;
	}

	/**
	 * The setFoldersAndArticlesCustomFields takes a Map of JournalFolders to
	 * JournalArticles and and sets the following customs fields: for
	 * JournalFolders: Byline (authors) for JournalArticles: Parent Issue, Order.
	 */
	public static void setFoldersAndArticlesCustomFields(Map<JournalFolder, List<JournalArticle>> foldersToArticles) {
		// set all custom fields attributes of folders and articles (such as Parent
		// Issue, Order, etc.)
		for (JournalFolder journalFolder : foldersToArticles.keySet()) {
			long FolderIssueNumber = (long) journalFolder.getExpandoBridge().getAttribute("Issue number");
			List<JournalArticle> articles = foldersToArticles.get(journalFolder);
			Set<String> authors = new HashSet<>();
			int numArticlesInIssue = articles.size();
			int orderInIssue = numArticlesInIssue;
			for (JournalArticle article : articles) {
				article.getExpandoBridge().setAttribute("Parent Issue", FolderIssueNumber);
				article.getExpandoBridge().setAttribute("Order", orderInIssue);
				orderInIssue--;
				authors.add((String) article.getExpandoBridge().getAttribute("Author"));
			}

			// get authors as string in comma separated format
			if (authors.size() == 1) {
				// get individual author from set (string includes brackets)
				String author = authors.toString();
				// remove brackets from author string
				journalFolder.getExpandoBridge().setAttribute("Byline", author.substring(1, author.length() - 1));
			} else if (!authors.isEmpty()) {
				// get authors and remove trailing ', ' (comma and space)
				journalFolder.getExpandoBridge().setAttribute("Byline", String.join(", ", authors).substring(2));
			}
		}
	}

	/**
	 * The getCommaSeparatedInts takes a List of Integers as input and returns a
	 * String of its values separated by commas.
	 */
	public static String getCommaSeparatedInts(List<Integer> years) {
		// get years in string comma separated format to use for tabs in jsp
		StringBuffer commaSeparatedYears = new StringBuffer("");
		for (Integer year : years) {
			commaSeparatedYears.append(year);
			commaSeparatedYears.append(",");
		}
		return commaSeparatedYears.toString();
	}
}
