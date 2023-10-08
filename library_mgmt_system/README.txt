Library Management System
Prajil Bhagat (2022359)
  

I have tried making a library management system as needed for our Advanced Programming Assignment-1 using the OOPS concepts in JAVA. 
Abstraction and Encapsulation concepts are primarily used in my code. 
The code runs perfectly as per the sample run provided to us.
The two interfaces for members or librarian is well executed with the functionalities needed. 
While loop and, if else, statements are used for making the menu-driven interface and switch case for making the different dials for options.
Major two classes for ‘Member’ and ‘Book’ are created, which includes all the attributes and methods required for the code to successfully run as per the assignment requirements.

Member class:
* name, age, phone_no, member_id, and fine are its basic attributes. Fine and member_id are not in the constructor, though.
* My_books and issuedDates are the two array lists used for keeping track of book issuance.
* A lot of getters are used. 
get_number_of_issued, getissuedDate, getfine, getmy_books, getname, getage, getphone_no, getmember_id.
* And also a issuebook() method is used for recording issued time and bookid.

Book class: 
* It includes just the constructor attributes: title, author and book_id.


* The assignment is done in Eclipse as a Maven Project. ‘Sourcecode.java’ is the main java class created under package name ‘org.library_mgmt_system’ in the src/main/java section. The jar file is firstly created after running the pom.xml as ‘maven install’.


* Then, the main class has been added in the manifest.mf file using the plugin, which helped in for the execution of the jar file in the terminal using the command 
>java -jar library_mgmt_system-0.0.1-SNAPSHOT.jar


* Input validation is not implemented:  If the inputs are okay, i.e. if we input an integer when asked basic age type field, then the code works completely well. It shows no error elsewhere, except if we put the wrong input types.