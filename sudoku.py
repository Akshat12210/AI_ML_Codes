"""
Given a 9*9 matrix  which is subdivided in 3*3 blocks with some places blank and some filled with numbers from 1-9
the problem is to fill the remaining spaces using numbers from 1-9
under the condition that 
    1. there should be no repetition of numbers in each row and column
    2. and there should be  no repition of numbers in a 3*3 block
"""
import numpy as np
sudoku=np.array([
    [4,5,0,0,0,0,0,0,0],
    [0,0,2,0,7,0,6,3,0],
    [0,0,0,0,0,0,0,2,8],
    [0,0,0,9,5,0,0,0,0],
    [0,8,6,0,0,0,2,0,0],
    [0,2,0,6,0,0,7,5,0],
    [0,0,0,0,0,0,4,7,6],
    [0,7,0,0,4,5,0,0,0],
    [0,0,8,0,0,9,0,0,0]
  ])

  
def checkPossible(row,col,sudoku,val):
  for i in range(0,9):
    if(sudoku[row][i]==val):
      return False
    if(sudoku[i][col]==val):
      return False
    if(sudoku[int(3*int(row/3)+(i/3))][int(3*int(col/3)+(i%3))]==val):
      return False
  return True

def solve(sudoku):
  for i in range (0,9):
    for j in range(0,9):
      if(sudoku[i][j]==0):
        for k in range(1,10):
          if(checkPossible(i,j,sudoku,k)):
            sudoku[i][j]=k;
            solutionPossible = solve(sudoku)
            if(solutionPossible):
              return True
            else:
              sudoku[i][j]=0;
        return False
  return True



print("Question\n",sudoku)
solve(sudoku)
print("Solved\n",sudoku)