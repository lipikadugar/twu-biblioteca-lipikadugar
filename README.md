Bibliotica
===================================
Biblioteca is a Library Management System for Bangalore Public Library. This application is designed to perform the following functions:

[1] List the Book Details

[2] List the Movie Details

[3] Checkout and Return Book or Movie

[4] Librarian can view the details of the users who checked out the book or movie.

[5] User can view their profile


Requirements
=============

The requirements of this application are:

[1] IntelliJ IDEA

[2] Ant

[3] JUnit 4.11

[4] Hamcrest Core 1.3

[5] Mockito-all-1.9.5

Include JUnit 4.11, Hamcrest Core 1.3 and Mockito-all-1.9.5 in the lib folder.

Installation
=============

Download the package from https://github.com/lipikadugar/twu-biblioteca-lipikadugar

From the terminal you can pull using the following command:

    git clone https://github.com/lipikadugar/twu-biblioteca-lipikadugar.git


How to Build
=============

This application is build using the Ant Build System. You can change your build settings by changing
the **build.xml** present in the project directory. To build the application, type the following
command in your shell:

   $ant

How to Run?
============

To run the application in your system, just open the application in IntelliJ IDEA,
then goto Run -> Run or you can press Ctrl + Shift + F10.

From the terminal type the following command:

    $ant run

Description
============

To list the book and movie details the user need not login.
Where as to perform checkout and return, user must login using the any of the following two credentials:

User ID  : 000-0000
Password : !abcd0123

User ID  : 000-0001
Password : !abcd1234

To access teh librarian account in order to list the checked out list details, use any one of the following two credentials:

User ID  : 999-9999
Password : biblioteca

User ID  : 999-9998
Password : biblioteca




