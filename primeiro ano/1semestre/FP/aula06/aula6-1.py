

# Crie a função finalGrade aqui...
# tem de devolver (student_name, grade)
def finalGrade(student_id, lst):
    # Assumindo que o aluno existe…
    for reg in lst:
        if student_id == int(reg[0]):
            nota1 = float(reg[-3])
            nota2 = float(reg[-2])
            nota3 = float(reg[-1])
            grade = (nota1 + nota2 + nota3) / 3
            return reg[1], grade

    return None, -1


def listAllStudents(lst):
    print("{:<6s} {:<50s} {}".format("Numero", "Nome", "Nota"))
    for reg in lst:
        nome = reg[1]
        numero = int(reg[0])
        nota = finalGrade(numero, lst)[1]
        print("{:<6d} {:<50s} {:.1f}".format(numero, nome, nota))


# Crie a função gradeSheet aqui...
def writeGradeSheet(fname, lst):
    with open(fname, 'w') as outFile:
        print("{:<6s} {:<50s} {}".format("Numero", "Nome", "Nota"),
              file=outFile)
        for reg in lst:
            nome = reg[1]
            numero = int(reg[0])
            nota = finalGrade(numero, lst)[1]
            print("{:<6d} {:<50s} {:.1f}".format(numero, nome, nota),
                  file=outFile)


def main():
    option = 0
    classes_list = []

    while option != 5:
        option = printMenuAndGetOption()
        if not optionIsValid(option, (1, 6)):
            print("The inserted option is not valid. Try Again.")

        if option == 1:
            filename = input("File name: ")
            loadFile(filename, classes_list)
        elif option == 2:
            studentNumber = int(input("Student number: "))
            student, grade = finalGrade(studentNumber, classes_list)
            if student == None:
                print("There is no such student.")
            else:
                print(
                    "The final grade of {} is {:.1f} values out of 20.".format(
                        student, grade))
        elif option == 3:
            listAllStudents(classes_list)
        elif option == 4:
            filename = input("File name: ")
            writeGradeSheet(filename, classes_list)


# Call main function
if __name__ == "__main__":
    main()
