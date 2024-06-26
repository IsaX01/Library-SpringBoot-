USE [master]
GO
/****** Object:  Database [Library]    Script Date: 5/27/2024 12:54:50 PM ******/
CREATE DATABASE [Library]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Library', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Library.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Library_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Library_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Library] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Library] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Library] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Library] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Library] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Library] SET ARITHABORT OFF 
GO
ALTER DATABASE [Library] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Library] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Library] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Library] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Library] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Library] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Library] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Library] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Library] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Library] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Library] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Library] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Library] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Library] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Library] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Library] SET RECOVERY FULL 
GO
ALTER DATABASE [Library] SET  MULTI_USER 
GO
ALTER DATABASE [Library] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Library] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Library] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Library] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Library] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Library] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Library', N'ON'
GO
ALTER DATABASE [Library] SET QUERY_STORE = ON
GO
ALTER DATABASE [Library] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Library]
GO
USE [Library]
GO
/****** Object:  Sequence [dbo].[books_seq]    Script Date: 5/27/2024 12:54:51 PM ******/
CREATE SEQUENCE [dbo].[books_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Library]
GO
/****** Object:  Sequence [dbo].[loans_seq]    Script Date: 5/27/2024 12:54:51 PM ******/
CREATE SEQUENCE [dbo].[loans_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Library]
GO
/****** Object:  Sequence [dbo].[users_seq]    Script Date: 5/27/2024 12:54:51 PM ******/
CREATE SEQUENCE [dbo].[users_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[Books]    Script Date: 5/27/2024 12:54:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[book_id] [int] NOT NULL,
	[title] [varchar](255) NOT NULL,
	[author] [varchar](255) NOT NULL,
	[release_date] [date] NULL,
	[genre] [varchar](50) NULL,
	[language] [varchar](50) NULL,
	[qty] [int] NULL,
	[status] [varchar](20) NULL,
 CONSTRAINT [PK__Books__490D1AE18DC0A735] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Loan_Book]    Script Date: 5/27/2024 12:54:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loan_Book](
	[loan_id] [int] NULL,
	[book_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Loan_User]    Script Date: 5/27/2024 12:54:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loan_User](
	[loan_id] [int] NULL,
	[user_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Loans]    Script Date: 5/27/2024 12:54:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loans](
	[loan_id] [int] NOT NULL,
	[load_date] [date] NULL,
	[return_date] [date] NULL,
	[real_return_date] [date] NULL,
	[status] [varchar](20) NULL,
 CONSTRAINT [PK__Loans__A1F79554CA512EDC] PRIMARY KEY CLUSTERED 
(
	[loan_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/27/2024 12:54:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] NOT NULL,
	[first_name] [varchar](100) NOT NULL,
	[last_name] [varchar](100) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[address] [varchar](255) NULL,
	[role] [varchar](50) NULL,
	[profile_picture] [varchar](255) NULL,
	[status] [varchar](20) NULL,
 CONSTRAINT [PK__Users__B9BE370FA8811B30] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (3, N'Test Title Updated', N'Test Author', CAST(N'2000-09-07' AS Date), N'Romance', N'English', 23, N'Available')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (7, N'Test Title 2', N'Test Author ', CAST(N'2000-08-06' AS Date), N'Romance ', N'English ', 12, N'Available')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (8, N'Test Title 3', N'Test Author 3', CAST(N'2001-06-06' AS Date), N'Fantasy', N'English ', 2, N'Available')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (10, N'Test Title 4', N'Test Author', CAST(N'2000-07-07' AS Date), N'Action', N'English ', 22, N'Available')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (11, N'Test Title 5 Updated', N'Test Author Updated', CAST(N'2000-07-07' AS Date), N'Action ', N'English ', 12, N'Available')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (12, N'Test Title 6', N'Test Author ', CAST(N'2000-08-08' AS Date), N'Romance', N'Spanish', 0, N'Out of stock')
INSERT [dbo].[Books] ([book_id], [title], [author], [release_date], [genre], [language], [qty], [status]) VALUES (13, N'A Book ', N'An Author ', CAST(N'2024-07-07' AS Date), N'Javascript ', N'Japanesse', 0, N'Out of stock')
GO
INSERT [dbo].[Users] ([user_id], [first_name], [last_name], [email], [password], [address], [role], [profile_picture], [status]) VALUES (152, N'Isaias', N'Badia', N'isaiaybadia@gmail.com', N'$2a$10$wT/HZNSp2PVGMSBv7AV0BesFXQSC3dbz6JoBbEZNC3mnCnbuztWKq', N'Moca', N'Admin', N'', N'Active')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Users__AB6E6164B061E1F9]    Script Date: 5/27/2024 12:54:51 PM ******/
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [UQ__Users__AB6E6164B061E1F9] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Loan_Book]  WITH CHECK ADD  CONSTRAINT [FK__Loan_Book__book___3E52440B] FOREIGN KEY([book_id])
REFERENCES [dbo].[Books] ([book_id])
GO
ALTER TABLE [dbo].[Loan_Book] CHECK CONSTRAINT [FK__Loan_Book__book___3E52440B]
GO
ALTER TABLE [dbo].[Loan_Book]  WITH CHECK ADD  CONSTRAINT [FK__Loan_Book__loan___3D5E1FD2] FOREIGN KEY([loan_id])
REFERENCES [dbo].[Loans] ([loan_id])
GO
ALTER TABLE [dbo].[Loan_Book] CHECK CONSTRAINT [FK__Loan_Book__loan___3D5E1FD2]
GO
ALTER TABLE [dbo].[Loan_User]  WITH CHECK ADD  CONSTRAINT [FK__Loan_User__loan___403A8C7D] FOREIGN KEY([loan_id])
REFERENCES [dbo].[Loans] ([loan_id])
GO
ALTER TABLE [dbo].[Loan_User] CHECK CONSTRAINT [FK__Loan_User__loan___403A8C7D]
GO
ALTER TABLE [dbo].[Loan_User]  WITH CHECK ADD  CONSTRAINT [FK__Loan_User__user___412EB0B6] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Loan_User] CHECK CONSTRAINT [FK__Loan_User__user___412EB0B6]
GO
USE [master]
GO
ALTER DATABASE [Library] SET  READ_WRITE 
GO
