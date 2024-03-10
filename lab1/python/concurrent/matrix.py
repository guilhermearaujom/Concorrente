import random

def generate_matrix(size):
    return [[random.randint(250, 29500) for _ in range(size)] for _ in range(size)]
@staticmethod
def min(matrix, result):
    smallest = float('inf')

    for row in matrix:
        for element in row:
            if element < smallest:
                smallest = element

    result[1] = smallest


@staticmethod
def max(matrix, result):
    largest = float('-inf')

    for row in matrix:
        for element in row:
            if element > largest:
                largest = element
    result[0] = largest
    
