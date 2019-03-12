package moderate.Q16_10_Living_People;

import java.util.Random;

/**
 * Give a list of people with their birth and death years, implement a method to compute the year with the most number of
 * people alive. you may assume that all people were between 1900 and 2000(inclusive). If a person was alive during any portion
 * of that year, they should be included in that year's count. For example, Person (birth = 1908, death=1909) is included in the
 * counts for both 1908 and 1909.
 */
public class LivingPeople {
	
	public static int maxAliveYear(Person[] people, int min, int max) {
		int maxAlive = 0;
		int maxAliveYear = min;
		
		for (int year = min; year <= max; year++) {
			int alive = 0;
			for (Person person : people) {
				if (person.birth <= year && year <= person.death) {
					alive++;
				}
			}
			if (alive > maxAlive) {
				maxAlive = alive;
				maxAliveYear = year;
			}
		}

		return maxAliveYear;
	}
	
	public static void main(String[] args) {
		int n = 10000;
		int first = 0;
		int last = 200000;
		Random random = new Random();
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			int birth = first + random.nextInt(last - first);
			int death = birth + random.nextInt(last - birth);
			people[i] = new Person(birth, death);
			//System.out.println(birth + ", " + death);
		}
		
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			//int birth = first + random.nextInt(last - first);
			//int death = birth + random.nextInt(last - birth);
			//people[i] = new Person(birth, death);
			System.out.println(people[i].birth);
		}
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			//int birth = first + random.nextInt(last - first);
			//int death = birth + random.nextInt(last - birth);
			//people[i] = new Person(birth, death);
			System.out.println(people[i].death);
		}		
		
		int year = maxAliveYear(people, first, last);
		System.out.println(year);
	}

}
