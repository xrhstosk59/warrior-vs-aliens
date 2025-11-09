# Contributing to Warrior vs Aliens

Thank you for your interest in contributing to Warrior vs Aliens! This document provides guidelines and instructions for contributing to this project.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Development Setup](#development-setup)
- [Coding Standards](#coding-standards)
- [Submitting Changes](#submitting-changes)
- [Reporting Bugs](#reporting-bugs)
- [Suggesting Enhancements](#suggesting-enhancements)

## 🤝 Code of Conduct

This project adheres to a code of conduct that all contributors are expected to follow:

- Be respectful and inclusive
- Welcome newcomers and encourage diverse perspectives
- Accept constructive criticism gracefully
- Focus on what is best for the community and the project

## 💡 How Can I Contribute?

### Reporting Bugs

Before creating bug reports, please check existing issues to avoid duplicates. When creating a bug report, include:

- **Clear title and description**
- **Steps to reproduce** the issue
- **Expected behavior** vs. **actual behavior**
- **Java version** and **operating system**
- **Code samples** or **error messages** if applicable

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion, include:

- **Clear title and description** of the proposed feature
- **Use case**: Why this enhancement would be useful
- **Possible implementation** approach (if you have ideas)

### Pull Requests

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes
4. Run tests to ensure everything works
5. Commit your changes following our commit message guidelines
6. Push to your fork
7. Open a Pull Request

## 🔧 Development Setup

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- Git

### Setup Steps

1. **Fork and clone the repository**

```bash
git clone https://github.com/YOUR_USERNAME/warrior-vs-aliens.git
cd warrior-vs-aliens
```

2. **Build the project**

```bash
mvn clean install
```

3. **Run tests**

```bash
mvn test
```

4. **Run the game**

```bash
mvn exec:java -Dexec.mainClass="gr.university.warriorgame.Main"
```

## 📝 Coding Standards

### Java Style Guidelines

- Follow standard Java naming conventions
- Use meaningful variable and method names
- Keep methods focused and concise (Single Responsibility Principle)
- Add JavaDoc comments for all public classes and methods
- Use proper indentation (4 spaces, no tabs)

### Example JavaDoc

```java
/**
 * Calculates the damage dealt by an alien attack.
 * <p>
 * Damage is based on the number of attackers and the warrior's
 * current visibility level.
 * </p>
 *
 * @param attackers the list of attacking aliens
 * @param visibility the warrior's visibility percentage (0-100)
 * @return calculated damage value
 */
public int calculateDamage(List<Alien> attackers, int visibility) {
    // Implementation
}
```

### Code Organization

- Keep classes in the appropriate package: `gr.university.warriorgame`
- Place tests in the corresponding test package structure
- One public class per file
- Organize imports (remove unused ones)

### Testing

- Write unit tests for all new features
- Ensure all tests pass before submitting PR
- Aim for meaningful test coverage
- Use descriptive test method names

```java
@Test
void testWarriorDecreasePowerBelowZeroShouldSetToZero() {
    warrior.decreasePower(150);
    assertEquals(0, warrior.getPower());
}
```

## 📤 Submitting Changes

### Commit Message Guidelines

Follow the conventional commit format:

```
<type>(<scope>): <subject>

<body>

<footer>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

**Examples:**

```
feat(warrior): add new healing ability

Implement a healing mechanism that restores warrior's HP
when visibility reaches 100%.

Closes #42
```

```
fix(alien): correct damage calculation formula

The previous formula incorrectly calculated damage when
visibility was at 0%. This fix ensures minimum damage of 1.

Fixes #35
```

### Pull Request Process

1. **Update documentation** if you're changing functionality
2. **Add tests** for new features
3. **Ensure all tests pass**: `mvn test`
4. **Update README.md** if necessary
5. **Reference any related issues** in the PR description
6. **Request review** from maintainers

### PR Checklist

- [ ] Code follows the project's style guidelines
- [ ] Self-review of code completed
- [ ] Code is commented, particularly in hard-to-understand areas
- [ ] Documentation has been updated
- [ ] No new warnings are introduced
- [ ] Tests added for new features
- [ ] All tests pass locally
- [ ] Dependent changes have been merged

## 🐛 Reporting Bugs

### Bug Report Template

```markdown
**Describe the bug**
A clear and concise description of what the bug is.

**To Reproduce**
Steps to reproduce the behavior:
1. Run game with '...'
2. Select option '...'
3. See error

**Expected behavior**
What you expected to happen.

**Actual behavior**
What actually happened.

**Environment:**
- OS: [e.g., Windows 10, macOS 12.0, Ubuntu 22.04]
- Java Version: [e.g., 11, 17]
- Maven Version: [e.g., 3.8.6]

**Additional context**
Any other relevant information.
```

## ✨ Suggesting Enhancements

### Enhancement Template

```markdown
**Is your feature request related to a problem?**
A clear description of the problem.

**Describe the solution you'd like**
A clear description of what you want to happen.

**Describe alternatives you've considered**
Any alternative solutions or features you've considered.

**Additional context**
Any other context, mockups, or examples.
```

## 🎓 Learning Resources

If you're new to design patterns or Java development:

- [Design Patterns Book (Gang of Four)](https://en.wikipedia.org/wiki/Design_Patterns)
- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

## 📞 Questions?

If you have questions, feel free to:

- Open an issue with the `question` label
- Contact the maintainers

---

Thank you for contributing to Warrior vs Aliens! 🚀
