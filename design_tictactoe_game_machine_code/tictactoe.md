#  Schema Design, MVC & Tic Tac Toe 

##  Agenda
1. How to approach Schema Design  
2. MVC (Model–View–Controller) overview  
3. How to design Tic Tac Toe  
4. Requirement gathering & edge cases  
5. Class diagrams, schema design & code structure  


---

##  How to approach Schema Design 
Think of the database like LEGO blocks — you decide how pieces (tables) connect.

###  Relationship types
- **1:1** — one item ↔ one item  
  _Example_: Aadhar ↔ Person (each person has one Aadhar)
- **1:M (or M:1)** — one item ↔ many items  
  _Example_: Instructor → Batches (one instructor may have many batches)
- **M:M** — many ↔ many (use a mapping/junction table)  
  _Example_: Movies ↔ Actors → `MovieActor` mapping table

###  Practical tips
- For **primitive attributes** (strings, numbers) — create columns directly in the table.
  - Example: `Movie` table columns: `id`, `name`, `release_year`, `language`.
- For **non-primitive attributes / relationships** — design foreign keys or mapping tables.
- Always **identify the "one" and "many" sides** early.

---

##  Quick Example: Movies & Actors
- `Movie(id, name, release_year, language)`  
- `Actor(id, name, birth_year)`  
- `MovieActor(movie_id FK, actor_id FK)` — bridge for M:M

---

##  MVC (Model–View–Controller) — super simple
- **Model**: Data + rules (e.g., `Movie`, `User`, `Board`)  
- **View**: What the user sees (UI / API responses)  
- **Controller**: Receives requests, calls services/models, returns view

Recommended folders:
project/
├─ models/
├─ controllers/
├─ services/
├─ factory/

Start with models, then services, then controllers.

---

##  Design Tic Tac Toe — step-by-step (ELI5)

### 1) Requirement gathering — always ask / clarify
Questions to finalize:
- Board size? (N x N — default 3x3 but keep N configurable)
- Number of players? (Usually 2)
- Bot required? (Yes/No —  **Yes**, only 1 bot per game)
- Bot difficulty levels? (Easy / Medium / Hard)
- Player symbols? (Each player picks a unique symbol — no duplicates)
- Who moves first? (Randomize player order at start)

**Interview tip:** If interviewer is vague, ask these — shows you understand scope and edge cases.

---

### 2) Winning rules
A player wins when they get their symbol across:
- an entire **row**, OR
- an entire **column**, OR
- a **diagonal**

Game ends when:
- Someone wins, OR
- Board is full → Draw

---

### 3) Entities (high-level)
- **Game**
  - `id`, `players[]`, `board`, `moves[]`, `status`
- **Board**
  - `size`, `cells[][]` (each cell holds player symbol or empty)
- **Player**
  - `id`, `name`, `symbol`, `isBot`, `botDifficulty`
- **Move**
  - `playerId`, `row`, `col`, `timestamp`

Decide: Do we persist the game? Mostly interviewer suggest **No** (in-memory is fine) — but you can persist if needed.

---

### 4) UNDO feature (Global UNDO)
Requirement :
- Anyone can press **UNDO** (global undo)  
- It removes the **latest move** from the board  
- Only allowed for the **last move** (one-step undo)  
- The turn should revert to the player who made the undone move

**Implementation approaches :**

#### A) Keep a history of moves (recommended for simplicity)
1. Store every move in a list `moves` in order.
2. UNDO:
   - Pop last move from `moves`.
   - Clear that cell on the board.
   - Set current player to the undone move's player.
Pros: Easy, low memory.  
Cons: Only supports undoing last move (which is the requirement).

#### B) Re-play from start (less efficient)
1. Remove the Nth move by resetting the board and re-applying the first N-1 moves.
Pros: Can support arbitrary removals if needed.  
Cons: Higher time complexity (reapply many moves).

#### C) Store board snapshot after every move
1. After each move, save the board state (deep copy).
2. UNDO: remove the latest snapshot and restore previous snapshot.
Pros: Fast undo (O(1) restore).  
Cons: Higher memory usage (store N snapshots).

The recommendation is snapshot as easy to implement and has good time complexity but uses memory.

---


