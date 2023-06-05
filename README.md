# VinEquip
![VinEquipLogo](/src/Resources/logoTransparent_1.png)
## Description

VinEquip is a desktop-based application designed to provide a convenient and user-friendly way for university students, faculty, and staff to book sports equipment such as rackets and balls.

## Prerequisites
Before you begin, make sure you have the following prerequisites installed on your system:

Java Development Kit (JDK) 8 or later
NetBeans IDE

### Installation Steps
1.  Clone [this repository](https://github.com/strixthekiet/Vinuni-COMP1020TermProject) to your local machine using the following command:
```shell
git clone https://github.com/strixthekiet/Vinuni-COMP1020TermProject
```
2. Launch NetBeans IDE and open the project by selecting "File" > "Open Project" and navigating to the cloned repository's directory.

3. Once the project is open, you may need to resolve any missing dependencies. Right-click on the project in the "Projects" pane and select "Resolve Project Problems". Follow the prompts to install any required libraries or dependencies. This includes
    - [JCalendar 1.4](ter.com/jcalendar)

4. Next, configure the project settings. Right-click on the project and select "Properties". In the properties window, navigate to the "Run" category.

5. In the "Main Class" field, ensure that the correct main class is selected (usually the class with the "main" method).

6. Establish database connection, run your MySQL server. Natigate to "src/Database/JavaJDBC.java" and edit the username and password to your MySQL user.

7. By pressing the "F6" key, run the project.
    - To log in as user, the sample user account is "hung" "hung".
    - To log in as admin, the sample admin account is "tri" "tri". 



## Features

- Real-time availability display of sports equipment, showing whether an item is available, reserved, or already booked.
- Booking history for users to view past reservations and upcoming bookings.
- Simple and streamlined booking process, with search options by category or specific item.
- Confirmation of bookings via email or SMS.
- Security measures, including password encryption and restricted access to user data.
- User Login: The system should allow users to log in to their accounts using their registered email and password.
- View Available Items: The system should allow users to view a list of available sports items, such as rackets and balls.
- Book Items: The system should allow users to book a sports item by selecting it from the available items list and specifying the booking date and time.
- View Booking History: The system should allow users to view their booking history, including past and upcoming bookings.
- User Profile: The system should allow users to view and update their profile information, such as their name, email, and password.
- Admin Login: The system should allow the administrator to log in using a separate login page.
- Admin Dashboard: The system should provide an admin dashboard where the administrator can cancel booking sports items, view booking history, and manage users.
- Add Sports Items: The system should allow the administrator to add new sports items to the system.
- Edit Sports Items: The system should allow the administrator to edit existing sports items, such as changing the name, description, or availability.
- Manage Users: The system should allow the administrator to manage user accounts, including creating new accounts.

## Benefits

- Data generation for inventory tracking and usage patterns.
- Optimization of equipment allocation and maintenance schedules.
- Real-time usage data for efficient resource utilization and equipment safety.

## Target Users

- University Sport Clubs
- Vinuniversity Students
- Faculty Members
