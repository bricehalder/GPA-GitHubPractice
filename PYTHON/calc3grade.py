midterm1grade = int(input('Enter midterm 1 grade: '))
midterm2grade = int(input('Enter midterm 2 grade: '))
hwGrade = int(input('Enter homework grade: '))

def grade(g, one, two, hw):
    return (g - (.2 * one) - (.2 * two) - (.2 * hw)) / 0.4

print('\nGrade needed on the final for...\n')
for i in range(5):
     print(str(100 - (5 * i)) + '% in the class is: ' +  str(grade(100 - (5 * i), midterm1grade, midterm2grade, hwGrade)))
