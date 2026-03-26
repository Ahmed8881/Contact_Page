# Contact App (Recycler / Grid)

A sleek, lightweight Android contact manager featuring a dual-interface approach. This application demonstrates advanced **RecyclerView** implementations, dynamic filtering, and custom dialog interactions.

---

##  Features

* **Quick-Add Interface:** Effortlessly create contacts with profile image support.
* **Dynamic Grid View:** A high-density overview of all saved contacts.
* **Search & Sort:** Real-time filtering and alphabetical sorting (ascending/descending).
* **CRUD Operations:** Full support for adding, editing, and deleting contact entries via intuitive dialogs.
* **Image Integration:** Support for custom profile pictures per contact.

---

##  Screenshots

| Add & Edit | Linear Layout | Grid View |
|:---:|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/29a771b4-fb4a-468f-855d-9e62b822a40f" width="200" /> | <img src="https://github.com/user-attachments/assets/65d2b9fd-66f5-464d-9069-f43a79a25fea" width="200" /> |<img src="https://github.com/user-attachments/assets/158e216c-3244-4081-9448-67573b62922c" width="200" /> |
| *Quick-Update Entry* | *Search* | *Sorting Descending* |
|  <img src="https://github.com/user-attachments/assets/7b7190d6-1699-4ebd-aa48-288018aab37d" width="200" />| <img src="https://github.com/user-attachments/assets/f97e3541-aac8-458e-890d-387116f805e7" width="200" /> | <img src="https://github.com/user-attachments/assets/c2025f46-9c93-4e1a-aae3-d459d45fc0d7" width="200" /> |

---

##  Technical Stack

* **Language:** Kotlin
* **UI Framework:** Android XML (View-based)
* **Architecture:** Activity-based with Custom Adapters
* **Components:** RecyclerView (GridLayoutManager), AlertDialogs, Intent System

### Key Files
* `MainActivity.kt`: Handles the entry form, image picking logic, and data orchestration.
* `ViewAllContactsActivity.kt`: Manages the high-level grid display, search queries, and sorting logic.
* `ContactGridAdapter.kt`: Custom adapter for efficient view recycling and data binding.

---

##  Getting Started

### Prerequisites
* Android Studio Ladybug (or newer)
* **JDK 17+** (Required for Gradle compatibility)
* Android API Level 24+

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/Ahmed8881/Contact_Page.git]
