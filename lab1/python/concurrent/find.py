from matrix import generate_matrix, max, min
import sys
import threading
import time

result = [0, 0]
if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Use: python3 find.py <size>")
        sys.exit(1)

    try:
        size = int(sys.argv[1])
    except ValueError:
        print("The size of the matrix must be an integer.")
        sys.exit(1)

    matrix = generate_matrix(size)
    
    if __name__ == "__main__":
        thMax = threading.Thread(target=max, args=(matrix,result))
        thMin = threading.Thread(target=min, args=(matrix,result))

        thMax.start()
        thMin.start()

        thMax.join()
        thMin.join()


    print(f'Max value: {result[0]}')
    print(f'Min value: {result[1]}')
