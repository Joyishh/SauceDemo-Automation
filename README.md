# SauceDemo Automation Framework 🚀

![Katalon Studio](https://img.shields.io/badge/Made%20with-Katalon%20Studio-green) ![Language](https://img.shields.io/badge/Language-Groovy-blue) ![Target](https://img.shields.io/badge/Target-SauceDemo-orange)

An automated testing framework for the **[Swag Labs (SauceDemo)](https://www.saucedemo.com/)** e-commerce website.

Built using **Katalon Studio**, this project goes beyond simple record-and-playback by implementing **Groovy scripting** to handle complex business logic validations, such as dynamic sorting algorithms and precise price calculations.

## 📋 Features & Test Coverage

This project covers the following end-to-end scenarios based on the repository scripts:

### 1. Authentication (Login) 🔐
* **Positive Case:** Successful login with valid credentials (`standard_user`).
* **Negative Case:** Error message validation for invalid credentials.
* **Edge Case:** Verification for locked-out user accounts (`locked_out_user`).

### 2. Advanced Product Filtering 📊
Validates sorting algorithms dynamically by parsing UI data into Lists/Arrays:
* **Price (Low to High) & (High to Low):** Scripts parse product prices into `Double`, programmatically sort them using `Collections.sort`, and compare them against the UI order.
* **Name (A to Z) & (Z to A):** Validates alphabetical sorting of product names.

### 3. Shopping Cart & Inventory 🛒
* Add products to the cart from both the Inventory and Product Detail pages.
* Remove products from the cart.
* Ensure item persistence when navigating back to shopping.

### 4. Checkout & Math Validation 🧮
Performs precise mathematical verifications (found in `TC-CHEK-001`):
* **Form Validation:** Validates mandatory fields (First Name, Last Name, Zip Code).
* **Total Calculation:** The script captures individual item prices, calculates **Subtotal + Tax**, and compares the result with the **Grand Total** displayed on the screen (handling decimal rounding via `Math.round`).

## 🛠️ Tech Stack

* **Tools:** Katalon Studio (v10.x)
* **Language:** Groovy
* **Design Pattern:** Page Object Model (via Object Repository)
* **Browsers:** Chrome, Chrome Headless

## 📂 Project Structure

    ├── Object Repository/   # UI Elements (XPath/CSS Selectors)
    ├── Profiles/            # Global Variables (Environment Config)
    ├── Scripts/             # Groovy Logic for each Test Case
    ├── Test Cases/          # Modular Test Case Definitions
    └── Test Suites/         # Test Execution Collections

## ⚙️ How to Run

### 1. Clone the Repository
Open your terminal and run:

    git clone https://github.com/Joyishh/SauceDemo-Automation.git

### 2. Open in Katalon Studio
* Launch **Katalon Studio**.
* Go to **File > Open Project**.
* Navigate to the cloned folder and select the `.prj` file.

### 3. Setup Drivers
Ensure your web drivers are up-to-date.
* Go to **Tools > Update WebDrivers > Chrome**.

### 4. Run Test
* Open any **Test Case** inside the `Test Cases` folder.
* Click the **Run** button (Select *Chrome* or *Chrome Headless*).
