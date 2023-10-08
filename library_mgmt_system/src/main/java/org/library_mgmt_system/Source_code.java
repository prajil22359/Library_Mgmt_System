package org.library_mgmt_system;
import java.util.*;




	class Book{
		String title;
		String author;
		int book_id;
		
		Book(String title, String author){
			this.title=title;
			this.author=author;
		}

		public String gettitle() {
			return this.title;
		}

		public String getauthor() {
			return this.author;
		}
		
		public int getbookid() {
			return this.book_id;
		}
	}
	
public class Source_code {
	
	static class Member{
		String name;
		int age;
		String phone_no;
		int member_id;
		long fine=0;
		
		List<Integer> my_books = new ArrayList<>();
		List<Long> issuedDates = new ArrayList<>();
		
		
		// constructor
		Member(String name, int age, String phone_no){
			this.name= name;
			this.age=age;
			this.phone_no= phone_no;
		}
		
		
		public int get_number_of_issued() {
			return this.my_books.size();
		}
		
		public void issueBook(int bookid) {
	        my_books.add(bookid);
	        issuedDates.add(System.currentTimeMillis());
		}
		
		public List<Long> getissuedDates(){
			return this.issuedDates;
		}
		
		public long getfine() {
			return this.fine;
		}
		
		public List<Integer> getmy_books() {
			return this.my_books;
		}
		
		public String getname() {
			return this.name;
		}

		public int getage() {
			return this.age;
		}
		
		public String getphone_no() {
			return this.phone_no;
		}
		
		public int getmemberid() {
			return this.member_id;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Member> member_list = new ArrayList<>();
		List<Book> book_list = new ArrayList<>();
		
		List<Integer> available_books = new ArrayList<>();
		List<Integer> issued_books = new ArrayList<>();
		
		while(true) {
			
		System.out.println("Library portal initialized...");
		System.out.println("1. Enter as a librarian\n"+"2. Enter as a member\n"+ "3. Exit");
		
		Scanner input= new Scanner(System.in);
		int input1=input.nextInt();
		boolean flag= true;
		
		int memberid=1000; // to record member_id
		int bookid=2000;
		Member this_member = null;
		if(input1==1) {
			do{
			System.out.print("1. Register a member\n2. Remove a member\n3. Add a book\n");
			System.out.print("4. Remove a book\n5. View all members along with their books and fines to be paid\n");
			System.out.println("6. View all books\n7. Back");
			int input2= input.nextInt();
			switch(input2) {
			
			case 1: // registering members

				System.out.println("NAME");
				String name= input.next();
				System.out.println("AGE");
				int age= input.nextInt();
				System.out.println("PHONE NO.");
				String phone_no= input.next();
				
				Member member = new Member(name, age, phone_no);
				member.member_id=memberid;
				member_list.add(member);
				
				System.out.println("Member successfully registered with MemberID-->" + memberid +"\n");
				memberid+=1;         
				
				
				flag=true;
				break;
				
				
			case 2: // removing members
				// finding through member_id...
				System.out.println("Give me the memberid of the member whom you want to remove");
				int member_id_to_remove= input.nextInt();
								
//				for (Member objectToPrint : member_list) {
//					if(objectToPrint.getmemberid()==member_id_to_remove) {
//						member_list.remove(objectToPrint);}
				//        ----> concurrent modification exception: you can't be modifying and iterating over the same list.
				// so,
				
				Iterator<Member> iterator = member_list.iterator();
				while (iterator.hasNext()) {
				    Member objectToPrint = iterator.next();
				    if (objectToPrint.getmemberid() == member_id_to_remove) {
				        iterator.remove(); // Removes the matching member from the list
				    }
				}
				System.out.println("Member removed");
				
				flag=true;
				break;
				
			case 3:
				
				System.out.println("Book Title");
				String title= input.next();
				System.out.println("Book Author");
				String author=input.next();
				System.out.println("No. of copies");
				int copies=input.nextInt();
				
				for(int i=1; i<=copies; i++){
					Book book= new Book(title, author);
					book.book_id=bookid;
					book_list.add(book);
					available_books.add(bookid);
					System.out.printf("Book added successfully under bookID %d \n",bookid );
					bookid+=1;
				}
				flag=true;
				break;
				
				
			case 4:
				
				System.out.println("Give me the bookID of the book you want to remove");
				int removed_bookid= input.nextInt();
//				Book removed_book = book_list.get(removed_bookid);
//				System.out.printf("%s with bookID %d is removed.\n", removed_book.gettitle(), removed_bookid );
//				book_list.remove(Integer.valueOf(removed_bookid));
			
				Iterator<Book> iterator1 = book_list.iterator();
				while (iterator1.hasNext()) {
				    Book objectToremove = iterator1.next();
				    if (objectToremove.getbookid() == removed_bookid) {
				        iterator1.remove(); // Removes the matching member from the list
				        System.out.printf("%s with bookID %d is removed.\n", objectToremove.gettitle(), removed_bookid );
				    }
				}
				
				flag=true;
				break;	
				
				
			case 5:
				
				for (Member objectToPrint : member_list) {
				//Member objectToPrint =member_list.get(i);

		        System.out.printf("Name: %s, Age: %d, MemberID: %d\n", objectToPrint.getname(), objectToPrint.getage(),objectToPrint.getmemberid());
		        System.out.println("Issued bookIDs are: ");
		        for (int books: objectToPrint.getmy_books()){
		        	System.out.println(books );
		       
		        }
		        System.out.println("\n");
		        System.out.printf("Outstanding fine %d\n", objectToPrint.getfine());
				}
				
				flag=true;
				break;
				
			case 6:
				System.out.println("Booklist:");
				
				for (Book bookToPrint : book_list) {
				//Member objectToPrint =member_list.get(i);
		        System.out.printf("Title: %s, Author: %s, BookID: %d\n" ,bookToPrint.gettitle(), bookToPrint.getauthor(), bookToPrint.getbookid());
				}
				
				flag=true;
				break;

			case 7:
				flag=false;
				break;
				}
			} while(flag==true);
		

	}
		
		else if(input1==2){
			boolean flag1= false;
		
			System.out.println("Member name: ");
			String name=input.next();
			System.out.println("Phone number: ");
			String number=input.next();
			for (Member objectToPrint : member_list) {
//				System.out.println(objectToPrint.getphone_no()) ;   --> just checking if loop works.
				if((objectToPrint.getphone_no().equals(number))&& (objectToPrint.getname().equals(name))) {
					System.out.printf("Welcome %s. Member ID: %s \n",name,objectToPrint.getmemberid());
					this_member= objectToPrint;
					flag1=true;
					break;} }
			if (flag1==false){
				System.out.printf("Member with Name: %s and Phone No: %s doesn't exist.\n", name, number); 
			}
			else {
				
				do {
				System.out.print("1. List Available Books\n2. List My Books\n3. Issue book\n");
				System.out.println("4. Return book\n5. Pay Fine\n6. Back");
				
				int input2= input.nextInt();
				switch(input2) {
				
				case 1:
					for (Book bookToPrint : book_list) {
						if(available_books.contains(bookToPrint.book_id)) {
							System.out.printf("Title: %s, Author: %s, BookID: %d\n" ,bookToPrint.gettitle(), bookToPrint.getauthor(), bookToPrint.getbookid());
						}
					}
					
					flag=true;
					break;
					
				case 2:
					for (Book bookToPrint : book_list) {
						if( this_member.getmy_books().contains(bookToPrint.book_id)) {
							System.out.printf("Title: %s, Author: %s, BookID: %d\n" ,bookToPrint.gettitle(),bookToPrint.getauthor(), bookToPrint.getbookid());
						}
					}
					flag=true;
					break;
					
				case 3:
					System.out.println("BookID: ");
					int bookToissue = input.nextInt();
					
					
					if ((available_books.contains(bookToissue)==true) && (this_member.get_number_of_issued()<2)&& ( this_member.getfine()==0)) {
						issued_books.add(bookToissue);
						
						this_member.issueBook(bookToissue);
						
						
						available_books.remove(Integer.valueOf(bookToissue));
						System.out.println("Book Issued Successfully!");
					}
					else { 
						if ( this_member.getfine()!=0) {
							System.out.println("Please pay outstanding fine first.");
						}
						else if (this_member.get_number_of_issued()==2) {
							System.out.println("Two books already issued. Sorry!");
						}
						else {
						System.out.println("Book not available.");
						}
					}
					flag=true;
					break;
					
				case 4:
					long delay_days;
					long fine;
					System.out.println("BookID: ");
					int bookToreturn = input.nextInt();
					issued_books.remove(Integer.valueOf(bookToreturn));  
					available_books.add(bookToreturn);  
					long returnTimeMillis = System.currentTimeMillis();
					if (this_member.getmy_books().get(0)==bookToreturn) {
						delay_days=returnTimeMillis- this_member.getissuedDates().get(0);	
					}
					else {
						delay_days=returnTimeMillis- this_member.getissuedDates().get(1)-10000;	
					}
					if(delay_days>0) {
						delay_days=delay_days/1000;
						fine=delay_days*3;
					}
					else {
						fine=0;
					}
					if (this_member.fine==0) {
						this_member.fine=fine;
					}
					else {
						this_member.fine= this_member.fine + fine;
					}
					
					System.out.printf("Book returned Successfully! %d Rs fine has been charged for a delay of %d days\n",fine,delay_days);
					this_member.my_books.remove(Integer.valueOf(bookToreturn));
					flag=true;
					break;	
					
				case 5: // pay fine
					System.out.printf("you had a total fine of Rs %d. It has been paid successfully.", this_member.getfine());
					this_member.fine=0;
					flag=true;
					break;
				case 6:
					flag=false;
					break;
				}
				}while(flag==true);
			}
		}
		else {
				System.out.println("Thanks for visiting");
				System.exit(0);
		}
	
		}
	}
}