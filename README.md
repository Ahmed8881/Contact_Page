# Contact App (Recycler / Grid)

Simple Android contact manager with support for profile images, quick-add form and a full grid view with search & sort.

---

## Screenshots

<img width="320" alt="Added contact" src="https://github.com/user-attachments/assets/29a771b4-fb4a-468f-855d-9e62b822a40f" />
Image after adding a contact:

<img width="320" alt="Grid view" src="https://github.com/user-attachments/assets/65d2b9fd-66f5-464d-9069-f43a79a25fea" />

Grid view:

<img width="320" alt="Editing contact" src="https://github.com/user-attachments/assets/158e216c-3244-4081-9448-67573b62922c" />

Editing a contact (dialog):

<img width="320" alt="After update" src="https://github.com/user-attachments/assets/a46dcb74-01f2-4f13-8321-a729c286027c" />

After update:


<img width="320" alt="Delete contact" src="https://github.com/user-attachments/assets/7b7190d6-1699-4ebd-aa48-288018aab37d" />
Deleting a contact (confirm):

<img width="320" alt="After delete" src="https://github.com/user-attachments/assets/eed29bd8-c60f-4a8f-8af9-c14b0fa27d7d" />

After delete:


<img width="320" alt="Sorted descending" src="https://github.com/user-attachments/assets/bb2ae2c2-2068-49ca-a8c8-2baff45b6ae5" />
Sorted (descending):

<img width="320" alt="Search" src="https://github.com/user-attachments/assets/f97e3541-aac8-458e-890d-387116f805e7" />

Search example:


---

## Quick Start

Requirements

- Android Studio (recommended) or command-line Gradle
- JDK 17 (Gradle for this project requires Java 17+)

Build and run (from project root):

```bash
./gradlew assembleDebug
# or open the project in Android Studio and run
```

## Permissions

- `READ_CONTACTS` — optional import/sync from phone contacts

## Important files

- `app/src/main/java/com/example/contact_app_recycler_view/MainActivity.kt` — add form, image picker, save contact
- `app/src/main/java/com/example/contact_app_recycler_view/ViewAllContactsActivity.kt` — grid view, search, sort
- `app/src/main/java/com/example/contact_app_recycler_view/ContactGridAdapter.kt` — grid adapter

## Notes

- Contacts are stored in memory (no persistence). Add Room/SQLite for persistence.
- If the build fails with a JVM error, install/configure Java 17.

If you want, I can add persistent storage (Room), live sync between screens, or copy images to app storage.
