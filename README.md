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

* Users can Login
* Users can register (Name, email, college; Bryn Mawr College, Haverford College, Swarthmore College, Profile)
* Users can take pictures, write descriptions of items they want to sell, and post
* Users can take accept or retake picture
* Scroll through dashboard for items available (RecyclerView)
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
[This section will be completed in Unit 9]

### Networking
- Parse Network Request for Databases
  -  User database
  -  Post database

