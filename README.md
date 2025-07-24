# 🚗 DHK Cars – Pre-Owned Car Listing Platform

DHK Cars is a responsive and SEO-friendly web application built with Spring Boot, designed to manage and showcase **pre-owned car listings**. It allows admins to add car details with multiple image uploads, categorize cars as available or sold, and provides users with a modern interface to explore and inquire about vehicles.

---

## 🛠️ Tech Stack

- **Backend**: Java, Spring Boot, Spring Data JPA
- **Frontend**: Thymeleaf, HTML5, CSS3, Bootstrap 5
- **Database**: MySQL
- **File Upload**: Cloudinary (for storing car images)
- **Build Tool**: Maven

---

## ✨ Features

- 🔐 **Admin Panel**: Add, update, and delete car listings
- 📸 **Multiple Image Uploads** using Cloudinary
- 🚘 **Available & Sold Car Filters**
- 📱 **Mobile-Responsive Design**
- 🔍 **Detailed Car View Pages** with schema markup for SEO
- 💬 **Floating WhatsApp Button** for instant contact
- 🎨 Car ribbons (e.g. "Sold", "Available") with hover effects and animations
- 📥 **Inquiry Form** (coming soon)

---

## 📸 Screenshots

> Add your screenshots here (or Cloudinary URLs)

![Homepage Screenshot][(https://via.placeholder.com/800x400?text=Homepage)](https://github.com/Umar9696/Preowned-Cars/blob/master/Homepage.png?raw=true)
![Car Details Page][(https://via.placeholder.com/800x400?text=Car+Details+Page)](https://github.com/Umar9696/Preowned-Cars/blob/master/Availablecars.png?raw=true)

---

## 📂 Project Structure

Preowned-cars/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── dhkcars/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── static/
│ │ │ ├── css/
│ │ │ ├── js/
│ │ │ └── images/
│ │ └── templates/
│ └── test/
├── pom.xml
└── README.md
