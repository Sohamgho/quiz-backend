-- -------------------------
-- USERS TABLE DATA
-- -------------------------
INSERT INTO users (id, username, email, password)
VALUES 
(1, 'soham', 'soham@example.com', '1234'),
(2, 'ritam', 'ritam@example.com', 'abcd');

-- -------------------------
-- PHYSICS QUESTIONS TABLE DATA
-- -------------------------
INSERT INTO physics_questions (id, question, option_a, option_b, option_c, option_d, correct_option, difficulty, topic, set_number)
VALUES
(1, 'A particle moves in a circle with constant speed. Which of the following is true?', 'Velocity is constant', 'Acceleration is zero', 'Acceleration is towards the center', 'None', 'C', 'easy', 'Circular Motion', 1),
(2, 'What is the SI unit of power?', 'Joule', 'Newton', 'Watt', 'Pascal', 'C', 'easy', 'Work Power Energy', 1),
(3, 'If a body is thrown vertically upwards, what is its velocity at the highest point?', 'Zero', 'Maximum', 'Minimum', 'Same as initial', 'A', 'easy', 'Motion under Gravity', 1);

-- -------------------------
-- CHEMISTRY QUESTIONS TABLE DATA
-- -------------------------
INSERT INTO chemistry_questions (id, question, option_a, option_b, option_c, option_d, correct_option, difficulty, topic, set_number)
VALUES
(1, 'What is the pH of a neutral solution at 25°C?', '7', '0', '14', '1', 'A', 'easy', 'Acids and Bases', 1),
(2, 'Which of the following is an alkali?', 'NaOH', 'HCl', 'H2SO4', 'CH3COOH', 'A', 'medium', 'Bases', 1),
(3, 'Which gas is evolved when zinc reacts with HCl?', 'Oxygen', 'Hydrogen', 'Chlorine', 'Nitrogen', 'B', 'easy', 'Reactivity Series', 1);

-- -------------------------
-- MATH QUESTIONS TABLE DATA
-- -------------------------
INSERT INTO math_questions (id, question, option_a, option_b, option_c, option_d, correct_option, difficulty, topic, set_number)
VALUES
(1, 'If f(x) = x², then f\'(x) = ?', 'x', '2x', 'x²', '1', 'B', 'easy', 'Calculus', 1),
(2, 'If sinA = 3/5, then cosA = ?', '4/5', '3/5', '1/5', 'None', 'A', 'easy', 'Trigonometry', 1),
(3, 'Solve for x: 2x + 3 = 7', '1', '2', '3', '4', 'B', 'easy', 'Linear Equations', 1);

-- -------------------------
-- QUIZ ATTEMPTS TABLE DATA
-- -------------------------
INSERT INTO quiz_attempts (id, user_id, set_number, physics_score, chemistry_score, math_score, total_score, attempt_number)
VALUES
(1, 1, 1, 30, 20, 25, 75, 1),
(2, 2, 1, 25, 25, 20, 70, 1);
