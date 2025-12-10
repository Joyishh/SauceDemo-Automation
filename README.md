# SauceDemo Automation Framework 🚀

![Katalon Studio](https://img.shields.io/badge/Made%20with-Katalon%20Studio-green) ![Language](https://img.shields.io/badge/Language-Groovy-blue) ![Target](https://img.shields.io/badge/Target-SauceDemo-orange)

Project automation testing untuk situs e-commerce **[Swag Labs (SauceDemo)](https://www.saucedemo.com/)**.

Dibangun menggunakan **Katalon Studio**, project ini menerapkan pendekatan scripting (Groovy) untuk menangani validasi logika bisnis yang kompleks, seperti verifikasi algoritma sorting dan kalkulasi total harga secara akurat.

## 📋 Fitur & Cakupan Test

Project ini mencakup skenario pengujian *end-to-end* berikut:

### 1. Authentication (Login) 🔐
* **Positive Case:** Login sukses dengan user valid (`standard_user`).
* **Negative Case:** Validasi pesan error jika kredensial salah.
* **Edge Case:** Validasi login untuk user yang terblokir (`locked_out_user`).

### 2. Advanced Product Filtering 📊
Tidak hanya mengecek teks statis, automation ini memverifikasi algoritma sorting secara dinamis menggunakan manipulasi List/Array:
* **Price (Low to High) & (High to Low):** Script mengambil harga produk, melakukan parsing ke tipe data `Double`, dan membandingkan urutan UI dengan hasil sorting programatik (`Collections.sort`).
* **Name (A to Z) & (Z to A):** Validasi urutan alfabetis nama produk secara otomatis.

### 3. Shopping Cart & Inventory 🛒
* Menambahkan produk ke keranjang dari halaman Inventory dan Detail Product.
* Menghapus produk dari keranjang belanja.
* Memastikan data item persisten saat navigasi antar halaman (*Continue Shopping*).

### 4. Checkout & Math Validation 🧮
Bagian ini melakukan validasi perhitungan matematis secara presisi:
* **Mandatory Fields:** Validasi error message untuk First Name, Last Name, dan Zip Code.
* **Total Calculation:** Script mengambil harga satuan item, menghitung **Subtotal + Tax**, dan membandingkannya dengan **Grand Total** yang ditampilkan sistem (termasuk penanganan pembulatan desimal `Math.round`).

## 🛠️ Tech Stack

* **Tools:** Katalon Studio (Enterprise/Free)
* **Language:** Groovy
* **Design Pattern:** Page Object Model (via Object Repository)
* **Version Control:** Git

## 📂 Struktur Project

```text
├── Object Repository/   # Elemen UI (XPath/CSS Selectors)
├── Profiles/            # Global Variables (Environment Config)
├── Scripts/             # Logika Groovy untuk Test Case
├── Test Cases/          # Definisi Test Case (Modular)
└── Test Suites/         # Kumpulan eksekusi test
