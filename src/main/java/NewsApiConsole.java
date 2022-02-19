import java.util.List;
import java.util.Scanner;

import exception.NewsApiException;
import model.NewsAPi;
import model.NewsInfo;
import services.NewApiService;

public class NewsApiConsole {

	public static void main(String[] args) {{
		final NewApiService newsDBService = NewsAPi.getnewsapidb();

		System.out.println("Welcome the the NewsApp");

		while (true) {
			System.out.println("Select one from the following options: ");
			System.out.println("1. Show top rated movies for specified year.");
			System.out.println("2. Search for movie.");
			System.out.println("3. Exit.");
			System.out.println("Your choice: ");

			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			System.out.println("Your choice: " + input);

			switch (input) {
			case "1":
				System.out.println("Selected 1");
				System.out.println("Enter country gb, gr : ");
				String searchParam = sc.nextLine();
				System.out.println("Enter Category from sports , business : ");
				String searchParam2 = sc.nextLine();
				try {
									
					List<NewsInfo> results;
					results = newsDBService.searchFortopHeadlines(searchParam, searchParam2);
					System.out.println("Results are: ");
					System.out.println(results);
				} catch (NewsApiException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			case "2":
				System.out.println("Selected 2");
				System.out.print("Enter search parameter: ");
				String searchParam3 = sc.nextLine();
				String searchParam4 = sc.nextLine();
				String searchParam5 = sc.nextLine();
				String searchParam6 = sc.nextLine();
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


