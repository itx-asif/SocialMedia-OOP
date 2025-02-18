# Social Media Application

A Java-based social media platform that allows users to register, log in, create posts, and interact with other users through likes, comments, and profile management. The application integrates a backend MySQL database to manage user data, posts, comments, and likes, following the Model-View-Controller (MVC) architecture.

## Features

- **User Registration & Login**: Create an account and log in to the platform.
- **Post Creation & Management**: Create new posts, view them, and manage them (e.g., delete posts).
- **User Engagement**: Like and comment on posts.
- **Profile Management**: Users can update their profile information.
- **Database Integration**: Data is stored in a MySQL database using JDBC.

## System Requirements

### Hardware Requirements

- Processor: 2.0 GHz Dual Core or higher
- RAM: 4 GB or more
- Hard Drive: 1 GB free space
- Display: 1024x768 resolution or higher

### Software Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **SQL Database**: MySQL
- **JDBC Driver**: For connecting Java with MySQL
- **IDE**: NetBeans
- **Database Management Tool**: Xampp

### External Libraries

- **MigLayout**: A flexible and easy-to-use layout manager for Java Swing applications.
- **FlatLaf**: A modern flat look-and-feel for Swing applications.
- **MySQL Connector/J**: JDBC driver to connect Java applications with MySQL databases.

## Architecture

The application follows the **Model-View-Controller (MVC)** design pattern:

- **Model**: Represents the data layer that handles user data, posts, comments, and likes, and directly interacts with the database.
- **View**: The user interface (GUI) that allows interaction with the system (e.g., login, post creation, home feed).
- **Controller**: The logic layer that processes user input, communicates with the model, and handles actions like login, post creation, and user engagement.

## Database Structure

### Tables

- **Users**: Stores information about users (ID, first name, last name, email, password).
- **Posts**: Stores posts (ID, user ID, content, creation timestamp).
- **Comments**: Stores comments on posts (ID, post ID, user ID, content, timestamp).
- **Likes**: Stores likes on posts (ID, user ID, post ID).

### Relationships

- **Users to Posts**: One-to-many relationship (a user can create multiple posts).
- **Users to Comments**: One-to-many relationship (a user can make multiple comments).
- **Posts to Comments**: One-to-many relationship (a post can have multiple comments).
- **Users to Likes**: Many-to-many relationship (a user can like many posts).
- **Posts to Likes**: One-to-many relationship (a post can have multiple likes).

## Controller Layer

Each controller is responsible for managing specific functionality:

- **CreateComment.java**: Adds a new comment to a post.
- **CreatePost.java**: Creates a new post.
- **CreateUser.java**: Registers a new user.
- **DeletePost.java**: Deletes a post by its ID.
- **ReadLike.java**: Fetches likes for a specific post.
- **ReadPost.java**: Fetches details of a post.
- **ReadPostComments.java**: Retrieves comments for a post.
- **ReadUser.java**: Retrieves user information.
- **ReadUserPost.java**: Fetches posts created by a specific user.
- **UpdateUser.java**: Updates a user's profile information.

## User Interface

The application provides several screens for user interaction:

- **Login Screen**: For users to log in with their email and password.
- **Registration Screen**: For users to create a new account.
- **Home Screen**: Displays posts from users, with options to like, comment, and create new posts.
- **Profile Screen**: Allows users to update their profile information and preferences.
