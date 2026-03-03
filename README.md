# Expense Manager REST API 💰

Proste i wydajne REST API do zarządzania wydatkami osobistymi, zbudowane w oparciu o architekturę trójwarstwową. Projekt stworzony w celach edukacyjnych, demonstrujący umiejętność budowy backendu w ekosystemie Spring.

## 🚀 Technologie
* **Java 17+**
* **Spring Boot 3** (Spring Web, Spring Data JPA)
* **Baza Danych:** H2 (In-Memory)
* **Narzędzia:** Maven, Lombok, Git

## ⚙️ Funkcjonalności (CRUD)
Aplikacja wystawia następujące endpointy REST:

| Metoda HTTP | Endpoint | Opis |
| :--- | :--- | :--- |
| `GET` | `/expenses` | Pobiera listę wszystkich wydatków |
| `POST` | `/expenses` | Dodaje nowy wydatek |
| `PUT` | `/expenses/{id}` | Aktualizuje istniejący wydatek |
| `DELETE` | `/expenses/{id}` | Usuwa wydatek o podanym ID |

## 🛠️ Jak uruchomić?
1. Sklonuj repozytorium: `git clone [TUTAJ_WKLEJ_SWOJ_LINK_DO_GITHUB]`
2. Uruchom projekt przy pomocy Mavena lub zaimportuj do IntelliJ IDEA.
3. API będzie dostępne pod adresem: `http://localhost:8080`
4. Konsola bazy danych H2 dostępna pod adresem: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:expensedb`, User: `sa`, bez hasła).