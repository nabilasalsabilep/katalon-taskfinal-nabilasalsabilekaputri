# 📱 Katalon Final Task

This repository contains the final mobile automation testing task using **Katalon Studio** for the **Todo mobile application**. The tests follow a **Data-Driven Testing** approach and include both **if-else** and **switch-case** statements inside the test cases.


---

## ✅ Test Cases

### 1. `Add_Edit_Delete_Category`
- **Description**: Adds a category, edits it, and then deletes it.
- **Data Driven**: Uses `categoryData`.
- **Logic**: Uses **switch-case** to handle categories.

### 2. `Cancel_Adding_New_Task`
- **Description**: Simulates user cancelling task creation.
- **Data Driven**: Uses `taskData`.
- **Logic**:  **if-else** to ensure task is not saved after canceling.

### 3. `Add_New_Task`
- **Description**: Adds a new task into the application.
- **Data Driven**: Uses `taskData`.
- **Logic**: Uses **if-else** to validate added data and **switch-case** to handle category selection.

### 4. `Edit_Task`
- **Description**: Edits details of an existing task.
- **Data Driven**: Uses `taskData`.
- **Logic**:  Uses **if-else** to check if new data is valid and **switch-case** for changing task category.

### 5. `Copy_Task`
- **Description**: Copies an existing task and verifies duplicate.
- **Logic**:  Uses **if-else** to check whether the original task has been successfully copied.
  
### 6. `Delete_Task`
- **Description**: Deletes an existing task.
- **Logic**: Applies **if-else** to verify if the task exists after attempting deletion.

---

## 🧪 Test Suite

### `FunctionalTests`
- Contains a sequence of test cases:
  - `Add_Edit_Delete_Category`
  - `Cancel_Adding_New_Task`
  - `Add_New_Task`
  - `Edit_Task`
  - `Copy_Task`
  - `Delete_Task`
- Used to verify essential functionalities in the Todo mobile app.

---

## 📊 Data-Driven Testing

- `categoryData` (RawData for Internal Database)
- `taskData` (TestData for Imported Excel File)

---

## 🔁 Conditional Logic

- **if-else** statements are used for:
  - Input validation (empty or invalid)
  - Data binding result verification
  - UI state checks before action

- **switch-case** statements are used for:
  - Selecting category based on input text
  - Simplifying menu/option selections on screen

---

## 🚀 How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/nabilasalsabilep/katalon-taskfinal-nabilasalsabilekaputri.git
