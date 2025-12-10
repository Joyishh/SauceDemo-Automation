SauceDemo Automation Framework 🚀

Automated testing framework for the Swag Labs (SauceDemo) e-commerce website. Dibangun dengan Katalon Studio dan diperkuat dengan Groovy scripting untuk memvalidasi logika bisnis yang lebih kompleks, termasuk perhitungan harga dan pengujian sorting dinamis.

Features & Test Coverage
1. Authentication

Positive: Login sukses dengan kredensial valid.

Negative: Validasi pesan error.

Edge: Penanganan akun terkunci.

2. Advanced Product Filtering

Sorting diverifikasi secara programatis:

Harga Low–High dan High–Low menggunakan casting Double dan Collections.sort.

Nama A–Z dan Z–A untuk pengecekan alfabetis.

3. Shopping Cart & Inventory

Tambah dan hapus produk dari Inventory dan Product Detail.

Validasi persistensi item saat navigasi.

4. Checkout & Math Validation

Validasi mandatory fields.

Perhitungan Subtotal + Tax dan verifikasi Grand Total melalui perhitungan script (termasuk pembulatan desimal).

Tech Stack

Tools: Katalon Studio (v10.x)

Language: Groovy

Pattern: Page Object Model

Browsers: Chrome, Chrome Headless

Project Structure
├── Object Repository/   # UI Elements
├── Profiles/            # Global Variables
├── Scripts/             # Groovy Logic
├── Test Cases/          # Modular Test Case Definitions
└── Test Suites/         # Execution Collections

How to Run
1. Clone the Repository
git clone https://github.com/your-username/your-repo-name.git

2. Open in Katalon Studio

Buka Katalon Studio.

File > Open Project.

Pilih folder hasil clone dan buka file .prj.

3. Setup Drivers

Pastikan WebDriver versi terbaru.

Tools > Update WebDrivers > Chrome.

4. Run Test

Buka salah satu Test Case di folder Test Cases.

Klik tombol Run dan pilih Chrome atau Chrome Headless.
