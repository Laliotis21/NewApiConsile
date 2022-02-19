
import java.util.List;
import java.util.Scanner;

import exception.NewsApiException;
import model.NewsAPi;
import model.NewsInfo;
import services.NewApiService;
import model.NewsCountry;
import model.NewsCategory;
import model.Searchinglanguage;

public class NewsApiConsole {

	public static void main(String[] args) throws NewsApiException {{
		final NewApiService newsDBService = NewsAPi.getnewsapidb();
		//final IpFind ipFind = newsDBService.getlocationData();
		System.out.println("Welcome the the NewsApp");

		while (true) {
			System.out.println("Select one from the following options: ");
			System.out.println("1. Get HeadLines.");
			System.out.println("2. Search for news.");
			System.out.println("3. Exit.");
			System.out.println("Your choice: ");

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();


			switch (input) {
			case "1":
				System.out.println("if you want news from another country different from yours type 'yes' else type 'no'");
				String searchParam8 = sc.nextLine();
				System.out.println("If you want news from  all below categories type 'yes' else type 'no'");
				System.out.println(java.util.Arrays.asList(NewsCategory.values()));
				String searchParam11 = sc.nextLine();
				try {
					if(searchParam8.equals("yes") &&  searchParam11.equals("no")) {
					System.out.println("Enter Country from:");
					System.out.println(java.util.Arrays.asList(NewsCountry.values()));
					String searchParam9 = sc.nextLine();
					System.out.println("Enter Category from:");
					System.out.println(java.util.Arrays.asList(NewsCategory.values()));
					String searchParam2 = sc.nextLine();
					List<NewsInfo> results;
					results = newsDBService.searchFortopHeadlines(searchParam9, searchParam2);
					System.out.println("Results are: ");
					System.out.println(results);
					}
					else if (searchParam8.equals("yes") &&  searchParam11.equals("yes")) {
						System.out.println("Enter Country from:");
						System.out.println(java.util.Arrays.asList(NewsCountry.values()));
						String searchParam9 = sc.nextLine();
						NewsCategory[] category = NewsCategory.values();
						for(NewsCategory categor: category )
						{
							List<NewsInfo> results;
							results = newsDBService.searchFortopHeadlines(searchParam9, categor.toString());
							System.out.println("Results are: ");
							System.out.println(results);
						}
					}
					else if (searchParam8.equals("no") &&  searchParam11.equals("yes")) {
						String results2;
						results2 = newsDBService.getlocationData().getCountryCode();
						NewsCategory[] category = NewsCategory.values();
						for(NewsCategory categor: category )
							{
								List<NewsInfo> results;
								results = newsDBService.searchFortopHeadlines(results2, categor.toString());
								System.out.println("Results are: ");
								System.out.println(results);
							}
					}
					else {
					String results2;
					results2 = newsDBService.getlocationData().getCountryCode();	
					List<NewsInfo> results;
					System.out.println("Enter Category from:");
					System.out.println(java.util.Arrays.asList(NewsCategory.values()));
					String searchParam2 = sc.nextLine();
					results = newsDBService.searchFortopHeadlines(results2, searchParam2);
					System.out.println("Results are: ");
					System.out.println(results);
					System.out.println();
					}
				} catch (NewsApiException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			case "2":
				System.out.println("Selected 2");
				System.out.print("Keyword or phrase to search for in the article title and body: ");
				String searchParam3 = sc.nextLine();
				System.out.print("Enter source: ");
				String searchParam4 = sc.nextLine();
				System.out.print("Enter language from: ");
				System.out.println(java.util.Arrays.asList(Searchinglanguage.values()));
				String searchParam5 = sc.nextLine();
				System.out.print("Enter From date with format yyyy/mm/dd: ");
				String searchParam6 = sc.nextLine();
				System.out.print("Enter to date with format yyyy/mm/dd: ");
				String searchParam7 = sc.nextLine();
				try {
					final List<NewsInfo> results = newsDBService.searchForeverything(searchParam3, searchParam4, searchParam5, searchParam6, searchParam7);
					System.out.println("Results are: ");
					System.out.println(results);
				} catch (NewsApiException e) {
					System.err.println(e.getMessage());
				}
				break;
			case "3":
				System.out.println("Selected 3");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
			}

		}
	}

}

	}


