Original App Design Project - README Template
===

# Tri-Eco

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
Problem: Throughout the course of college, students accumulate a variety of objects that often go to waste, especially regarding reusable items like books or clothes. The pandemic has posed an additional barrier when it comes to the spread and sharing of personal belongings. 
Tri-Eco aims to reduce waste by providing a safe and easy method for students to donate and access reusable resources available within campus. In the Tri-Co, there is no site which can be used for safe utilization of the unused possessions of the students. Thus, the goal of our app is to create a centralized platform where Tri-Co students can buy, donate, and sell their belongings from each other. The items can include used or completely new books, clothes, stationery, interior/design items, or even furniture. We want to encourage students to be reasonable consumers and make more sustainable choices that will contribute to the overall ecological landscape of our planet.


### App Evaluation
- **Category:** Retail/Environment
- **Mobile:** This app is designed for android mobile devices only 
- **Story:** Reduces waste by providing a centralized platform that connects buyers and sellers of donations/used items (clothes, books, household supplies etc.) across the Tri-Co. 
- **Market:**Students of the Tri-co (Bryn Mawr College, Haverford College, Swarthmore College)
- **Habit:**This app will most likely be used often for as long as any student would like to buy an item from the app or sell one of their own items. 
- **Scope:** Our goal is to allow students from the Tri-Co community to engage in a more sustainable lifestyle. As the app develops, we hope to expand the app to others outside of the Tri-Co.


## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] set up Login activity 
- [x] set up SignUp activity
- [x] Users can Login
- [x] Users can signup
- [x] Users can logout
- [x] Users can see the item posted by the user displayed on user profile
- [x] User can see the information entered by the user while signing up displayed on their profile (username, email, college).
- [x] User can take a picture and save it as their profile picture.
* Users can register (Name, email, college; Bryn Mawr College, Haverford College, Swarthmore College, Profile)
- [x] Users can take pictures, write descriptions of items they want to sell, and post
- [x] Users can take accept or retake picture
- [x] Scroll through dashboard for items available (RecyclerView)
- [x] Add layout for user profile
* On choosing an item the user wants to buy, user can access contact info of seller (name, email, college, profile picture)
* Once transaction made, item removed from database and dashboard
* Users can create a profile (to sell)
* User can take profile picture (for identification)


**Optional Nice-to-have Stories**

* Users can directly email sellers of potential buyers
* Users can comment under the post
* Users can like the post 
* Users can process a payment through the app
* Users can interact with other users and message each other 


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/oshevchuk27/Tri-Eco/blob/main/Tri-Eco-Android/videowalkthrough2.gif' title='Video Walkthrough1' width='' alt='Video Walkthrough1' />

<img src='https://github.com/oshevchuk27/Tri-Eco/blob/main/Tri-Eco-Android/videowalkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />


### 2. Screen Archetypes


* Splash 
  * Users can Login
  * Users can register (Name, email, college; Bryn Mawr College, Haverford College, Swarthmore College, Profile)
* Login
  * Users can Login
* Register
  * Users can register (Name, email, college; Bryn Mawr College, Haverford College, Swarthmore College, Profile)
  * Access contact info of seller (name, email, college, profile picture)
* Sell 
  * Users can upload pictures and descriptions of items they want to sell
* Profile
  * Users can create a profile (to sell)
  * User can take profile picture (for identification)
* Dashboard
  * Scroll through dashboard for items available (RecyclerView)
* Contact Info
  * On choosing an item the user wants to buy, user can access contact info of seller (name, email, college, profile picture)
* Camera
  * Users can take pictures, write descriptions of items they want to sell, and post
  * User can take profile picture (for identification)
* Accept/Retake
  * Users can take accept or retake picture 
* Post/Cancel
  * Users can take pictures, write descriptions of items they want to sell, and post


### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Dashboard
* Sell
* Profile 


**Flow Navigation** (Screen to Screen)

* Splash 
  * Login - allows users to sign in
  * Register - allows users to register
  * App logo - design 
* Login	
  * Login => Dashboard
  * Register 
* Register
  * Register => Dashboard
  * Login
* Dashboard
  * Sell
  * Profile
  * Contact Info (of seller, after user clicks on item they wish to buy)
* Contact Info
  * Back (Dashboard)
* Sell 
  * Dashboard 
  * Profile
  * Click picture
    * Camera
        * Accept
            * Post => Dashboard (updated)
            * Cancel => Camera
        * Retake => Camera
* Profile
  * Sell
  * Dashboard
  * Click picture
      * Camera
          * Accept => Profile
          * Retake => Camera

  * Logout


## Wireframes
<img src = 'https://github.com/oshevchuk27/Tri-Eco/blob/main/IMG-2492.JPG' />


### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 

Data Models 

Post
| Property      | Type          |Description  |
| ------------- |:-------------:| -----:      |
| objectId      |String              |Unique ID for user post      |
| author        | Pointer to User    |   Posts user name |
| image         | File               | Iamge that user posts |
| caption       |String         |Caption posted by user      |
| createdAt     | DateTime      |Post when created |
| updatedAt     | DateTime      |Update when last posted |
| contact       | Pointer to User      |Directs user to contact info |

User 

| Property      | Type          |Description  |
| ------------- |:-------------:| -----:      |
| objectId      |String          |Display user name |
| email         |String          |Display email of user |
| image         | File           |Display user profile image |
| caption       |String          |Display telephone number |
| createdAt     | DateTime       |Display school within trico |

Sell
| Property     | Type             | Description  |
| -------------|:-------------:   | -----:      |
|objectId      |String            |Label product name |
|price         |String            |Input price info of product |
|image         |File              |Display captured image |
|caption       |String            |Display telephone number |
|Post/Cancel   |Relation to Post  |Options to post or remove a post|

### Networking
#### List of network requests by screen
- Dashboard screen
      - (Read/GET) Query all posts where user is author
     
     ```java
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
           query.whereEqualTo("playerName", currentUser);
           query.findInBackground(new FindCallback<ParseObject>() {
              public void done(List<ParseObject> scoreList, ParseException e) {
                 if (e == null) {
                     Log.d("score", "Retrieved " + scoreList.size() + " scores");
                 } else {
                     Log.d("score", "Error: " + e.getMessage());
                 }
              }
           });       
        ```
       
-  Sell screen
      - (Create/POST) Create a new post object

     ``` java
     ParseObject gameScore = new ParseObject("GameScore");
      gameScore.put("score", 1337);
      gameScore.put("playerName", "Sean Plott");
      gameScore.put("cheatMode", false);
      gameScore.saveInBackground();
      ```
      
      - (Update/PUT) Update existing post object

      ```java
      ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");

      // Retrieve the object by id
      query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
        public void done(ParseObject gameScore, ParseException e) {
          if (e == null) {
            // Now let's update it with some new data. In this case, only cheatMode and score
            // will get sent to your Parse Server. playerName hasn't changed.
            gameScore.put("score", 1338);
            gameScore.put("cheatMode", true);
            gameScore.saveInBackground();
          }
        }
      });
      ```
 
      - (Delete) Delete existing post object
      
      ```java
      myObject.deleteInBackground();
      ```
     
- Profile screen
      - (Read/GET) Query logged in user object
      - (Update/PUT) Update user profile image
      - (Update/PUT) Update user name
      - (Update/PUT) Update user email

           
         


