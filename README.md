# Generic-Sorter-in-Java
This project provides implementations of several sorting algorithms in Java, designed to handle arrays of various data types, including Integer and Long. The Sorter class supports sorting algorithms like QuickSort, MergeSort (Non-Recursive), and RadixSort. A comprehensive set of JUnit tests are included to ensure the correctness and robustness of the sorting algorithms.

Table of Contents

Project Structure
Features
Algorithms Implemented
Installation and Usage
Running Tests
Contributing
License
Project Structure

bash
Copy code
/src
  └── Sorter.java         # Main sorting class with all sorting algorithms
  └── SortAnalyser.java    # Class to analyze the performance of sorting algorithms
  └── SorterTestIdan.java  # JUnit test suite for testing sorting algorithms
Sorter.java
Contains the following sorting algorithms:

QuickSort (Generic implementation)
MergeSort (Non-Recursive)
RadixSort (Works on Long arrays)
SorterTestIdan.java
The test suite is written using JUnit5 and includes test cases for:

Sorting sorted arrays, reversed arrays, and random arrays
Handling edge cases like empty arrays, arrays with identical elements, and arrays with negative numbers
Randomized tests with both narrow and wide ranges of values
Features

Generic Sorting Algorithms: All sorting algorithms are implemented to handle any data type that implements Comparable<T>.
Performance Analysis: The SortAnalyser class helps benchmark the sorting algorithms on arrays of different sizes and value ranges.
Comprehensive Test Coverage: A wide range of test cases, including randomized arrays, edge cases, and pre-sorted data, ensure reliability.
Algorithms Implemented

QuickSort
QuickSort is an efficient, divide-and-conquer, in-place sorting algorithm. It uses a pivot element to partition the array into subarrays and recursively sorts them.

MergeSort (Non-Recursive)
MergeSort is a stable, divide-and-conquer sorting algorithm. This implementation uses an iterative (non-recursive) approach, which reduces the overhead of recursive calls and efficiently merges subarrays.

RadixSort
RadixSort is a non-comparative sorting algorithm that sorts Long arrays by processing each digit. It performs well when sorting large arrays of numbers with limited digits.

Installation and Usage

Prerequisites
Java 8 or higher
JUnit5 for testing

