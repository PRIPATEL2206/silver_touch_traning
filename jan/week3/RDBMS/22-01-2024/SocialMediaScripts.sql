USE [master]
GO
/****** Object:  Database [social_media]    Script Date: 22-01-2024 17:30:20 ******/
CREATE DATABASE [social_media]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'social_media', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\social_media.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'social_media_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\social_media_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [social_media] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [social_media].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [social_media] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [social_media] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [social_media] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [social_media] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [social_media] SET ARITHABORT OFF 
GO
ALTER DATABASE [social_media] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [social_media] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [social_media] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [social_media] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [social_media] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [social_media] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [social_media] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [social_media] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [social_media] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [social_media] SET  ENABLE_BROKER 
GO
ALTER DATABASE [social_media] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [social_media] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [social_media] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [social_media] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [social_media] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [social_media] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [social_media] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [social_media] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [social_media] SET  MULTI_USER 
GO
ALTER DATABASE [social_media] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [social_media] SET DB_CHAINING OFF 
GO
ALTER DATABASE [social_media] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [social_media] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [social_media] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [social_media] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [social_media] SET QUERY_STORE = OFF
GO
USE [social_media]
GO
/****** Object:  Table [dbo].[Comments]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comments](
	[comment_id] [int] IDENTITY(1,1) NOT NULL,
	[post_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[content] [varchar](500) NOT NULL,
	[timestamp] [datetime] NULL,
	[likes] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Friends]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Friends](
	[user_id] [int] NOT NULL,
	[friend_id] [int] NOT NULL,
	[status] [varchar](20) NULL,
	[relationship_type] [varchar](20) NULL,
	[best_friend] [bit] NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[friend_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Likes]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Likes](
	[user_id] [int] NOT NULL,
	[post_id] [int] NOT NULL,
	[liked_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notifications]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notifications](
	[notification_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[content] [varchar](255) NOT NULL,
	[isRead] [bit] NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[notification_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Posts]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Posts](
	[post_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[content] [varchar](255) NOT NULL,
	[created_at] [datetime] NULL,
	[media_type] [varchar](20) NULL,
	[media_url] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 22-01-2024 17:30:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[email_id] [varchar](100) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[profile_picture] [varbinary](max) NULL,
	[is_active] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Comments] ON 

INSERT [dbo].[Comments] ([comment_id], [post_id], [user_id], [content], [timestamp], [likes]) VALUES (6, 4, 6, N'Nice post!', CAST(N'2024-01-19T15:41:33.267' AS DateTime), 2)
INSERT [dbo].[Comments] ([comment_id], [post_id], [user_id], [content], [timestamp], [likes]) VALUES (7, 2, 7, N'Great photo!', CAST(N'2024-01-19T15:41:33.267' AS DateTime), 1)
INSERT [dbo].[Comments] ([comment_id], [post_id], [user_id], [content], [timestamp], [likes]) VALUES (8, 3, 5, N'Interesting video!', CAST(N'2024-01-19T15:41:33.267' AS DateTime), 3)
INSERT [dbo].[Comments] ([comment_id], [post_id], [user_id], [content], [timestamp], [likes]) VALUES (9, 4, 8, N'Thoughtful post!', CAST(N'2024-01-19T15:41:33.267' AS DateTime), 0)
INSERT [dbo].[Comments] ([comment_id], [post_id], [user_id], [content], [timestamp], [likes]) VALUES (10, 1, 5, N'Beautiful picture!', CAST(N'2024-01-19T15:41:33.267' AS DateTime), 2)
SET IDENTITY_INSERT [dbo].[Comments] OFF
GO
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (1, 2, N'accepted', N'friend', 1, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (2, 3, N'pending', N'friend', 0, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (3, 1, N'accepted', N'friend', 0, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (4, 5, N'accepted', N'friend', 1, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (6, 7, N'pending', N'friend', 0, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
INSERT [dbo].[Friends] ([user_id], [friend_id], [status], [relationship_type], [best_friend], [created_at]) VALUES (7, 4, N'accepted', N'friend', 0, CAST(N'2024-01-19T15:38:24.070' AS DateTime))
GO
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (1, 2, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (2, 3, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (4, 3, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (5, 1, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (6, 2, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
INSERT [dbo].[Likes] ([user_id], [post_id], [liked_at]) VALUES (7, 4, CAST(N'2024-01-19T15:40:43.690' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[Notifications] ON 

INSERT [dbo].[Notifications] ([notification_id], [user_id], [content], [isRead], [created_at]) VALUES (1, 5, N'You have a new friend request.', 0, CAST(N'2024-01-19T15:38:24.073' AS DateTime))
INSERT [dbo].[Notifications] ([notification_id], [user_id], [content], [isRead], [created_at]) VALUES (2, 6, N'Your post received a new like.', 0, CAST(N'2024-01-19T15:38:24.073' AS DateTime))
INSERT [dbo].[Notifications] ([notification_id], [user_id], [content], [isRead], [created_at]) VALUES (3, 8, N'Your friend request has been accepted.', 0, CAST(N'2024-01-19T15:38:24.073' AS DateTime))
INSERT [dbo].[Notifications] ([notification_id], [user_id], [content], [isRead], [created_at]) VALUES (4, 7, N'Your post received a new like.', 0, CAST(N'2024-01-19T15:38:24.073' AS DateTime))
SET IDENTITY_INSERT [dbo].[Notifications] OFF
GO
SET IDENTITY_INSERT [dbo].[Posts] ON 

INSERT [dbo].[Posts] ([post_id], [user_id], [content], [created_at], [media_type], [media_url]) VALUES (1, 5, N'This is my first post!', CAST(N'2024-01-19T15:38:24.070' AS DateTime), N'text', NULL)
INSERT [dbo].[Posts] ([post_id], [user_id], [content], [created_at], [media_type], [media_url]) VALUES (2, 6, N'Check out this amazing photo!', CAST(N'2024-01-19T15:38:24.070' AS DateTime), N'image', N'https://example.com/images/photo1.jpg')
INSERT [dbo].[Posts] ([post_id], [user_id], [content], [created_at], [media_type], [media_url]) VALUES (3, 6, N'Just posted a video tutorial!', CAST(N'2024-01-19T15:38:24.070' AS DateTime), N'video', N'https://example.com/videos/tutorial.mp4')
INSERT [dbo].[Posts] ([post_id], [user_id], [content], [created_at], [media_type], [media_url]) VALUES (4, 7, N'Thoughts on the latest tech trends.', CAST(N'2024-01-19T15:38:24.070' AS DateTime), N'text', NULL)
SET IDENTITY_INSERT [dbo].[Posts] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (1, N'JohnDoe123', N'johndoe@example.com', N'hashData1', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (2, N'JaneSmith456', N'janesmith@example.com', N'hashData2', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (3, N'BobJohnson789', N'bobjohnson@example.com', N'hashData3', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (4, N'EmilyDavis101', N'emilydavis@example.com', N'hashData4', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (5, N'Pratik123', N'pratik@example.com', N'hashData1', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (6, N'Prakash456', N'prakash@example.com', N'hashData2', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (7, N'Prince789', N'prince@example.com', N'hashData3', NULL, 1)
INSERT [dbo].[Users] ([user_id], [username], [email_id], [password], [profile_picture], [is_active]) VALUES (8, N'Kartik101', N'kartik@example.com', N'hashData4', NULL, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Comments] ADD  DEFAULT (getdate()) FOR [timestamp]
GO
ALTER TABLE [dbo].[Comments] ADD  DEFAULT ((0)) FOR [likes]
GO
ALTER TABLE [dbo].[Friends] ADD  DEFAULT ('pending') FOR [status]
GO
ALTER TABLE [dbo].[Friends] ADD  DEFAULT ('friend') FOR [relationship_type]
GO
ALTER TABLE [dbo].[Friends] ADD  DEFAULT ((0)) FOR [best_friend]
GO
ALTER TABLE [dbo].[Friends] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[Likes] ADD  DEFAULT (getdate()) FOR [liked_at]
GO
ALTER TABLE [dbo].[Notifications] ADD  DEFAULT ((0)) FOR [isRead]
GO
ALTER TABLE [dbo].[Notifications] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[Posts] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((1)) FOR [is_active]
GO
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[Posts] ([post_id])
GO
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Friends]  WITH CHECK ADD FOREIGN KEY([friend_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Friends]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Likes]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[Posts] ([post_id])
GO
ALTER TABLE [dbo].[Likes]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Notifications]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Posts]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
USE [master]
GO
ALTER DATABASE [social_media] SET  READ_WRITE 
GO
