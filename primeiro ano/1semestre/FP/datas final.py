# isLeapYear(year) deve devolver True se year é um ano bissexto
# e False se é um ano comum.  Corrija-a.
# (See: https://en.wikipedia.org/wiki/Leap_year)
from re import X


def isLeapYear(year):
  
    if (year % 4 == 0 and year%100 != 0 ) or (year%100 == 0 and year%400 == 0):
        return True
        
    else:
        return False

# monthDays deve devolver o número de dias de um dado mês num dado ano.
# Por exemplo, monthDays(2004, 2) deve devolver 29.
# Corrija-a.
def monthDays(year, month):
    diasdomês_comum = (0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    diasdomês_bissexto = (0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    if isLeapYear(year) == True:
        days = diasdomês_bissexto[month]
        return days
    else:
        days = diasdomês_comum[month]
        return days



# nextDay deve devolver o dia a seguir a uma dada data.
# Por exemplo, nextDay(2017, 1, 31) deve devolver (2017, 2, 1)
def nextDay(year, month, day):      
    if month == 1 and day == 31 :       #para os meses que possuem 31 dias
        day = 1
        month +=1
        return year,month,day
    elif month == 3 and day == 31 :
        day = 1
        month +=1
        return year,month,day
    elif month == 5 and day == 31 :
        day = 1
        month +=1
        return year,month,day
    elif month == 7 and day == 31 :
        day = 1
        month +=1
        return year,month,day
    elif month == 8 and day == 31 :
        day = 1
        month +=1
        return year,month,day
    elif month == 10 and day == 31 :
        day = 1
        month +=1
        return year,month,day

    elif month == 4 and day == 30: #para meses que possuem 30 dias
        day = 1
        month +=1
        return year,month,day
    elif month == 6 and day == 30:
        day = 1
        month +=1
        return year,month,day
    elif month == 9 and day == 30:
        day = 1
        month +=1
        return year,month,day
    elif month == 11 and day == 30:
        day = 1
        month +=1
        return year,month,day
                           #excessões
    elif month == 2 and day == 28 and (isLeapYear(year) == True):
        day += 1
        return year,month,day
    elif month == 2 and day == 28 and (isLeapYear(year) == False):
        day =1
        month += 1
        return year,month,day
    elif month == 12 and day == 31 :
        day = 1
        month = 1
        year +=1
        return year,month,day
    else:
        day=+1
        return year,month,day
# Defina uma função dateIsValid que deve
# devolver True se os seus argumentos formarem uma data válida
# e devolver False no caso contrário.
# Por exemplo, dateIsValid(1980, 2, 29) deve devolver True,
# dateIsValid(1980, 2, 30) deve devolver False.
def dateIsValid(year, month, day):
    if year < 1:
        return False
    else:
        pass
    if month < 1 or month > 12:
        return False
    else:
        pass
    if monthDays(year, month) < day:
        return False
    else:
        pass
    if day < 1:
        return False
    else:
        pass             
    if month == 2:
        if (isLeapYear(year) == True) and day > 29:
            return False
        elif (isLeapYear(year) == False) and day > 28:
            return False 
        else:
            pass
    
    return True    


# Defina uma função previousDay que devolva o dia anterior a uma dada data.
# Por exemplo, previousDay(1980, 3, 1) deve devolver (1980, 2, 29)
def previousday(day,month,year):
    x = ( 5, 7, 10)
    y = (4, 6, 9, 11)
    if day == 1 and month == 5:
        month -=1
        day = 30
        return day,month,year
    elif day == 1 and month == 7:
        month -=1
        day = 30
        return day,month,year
    elif day == 1 and month == 10:
        month -=1
        day = 30
        return day,month,year


    elif day == 1 and month == 4:
        month -=1
        day = 30
        return day,month,year


    elif day == 1 and month == 6:
        month -=1
        day = 31
        return day,month,year

    elif day == 1 and month == 9:
        month -=1
        day = 31
        return day,month,year
    
    elif day == 1 and month == 9:
        month -=1
        day = 31
        return day,month,year




#excessões


    elif day == 1 and month == 2:
            month -=1
            day = 31
            return day,month,year
        
    elif day == 1 and month == 3 and (isLeapYear(year) == True):
            month -=1
            day = 29
            return day,month,year
    elif day == 1 and month == 3 and (isLeapYear(year) == False):
            month -=1
            day = 28
            return day,month,year

    elif day == 1 and month == 8:
            month -=1
            day = 31
            return day,month,year
    elif day == 1 and month == 1:
            month =12
            year -= 1
            day   = 31
    else:
        day = day -1 

    return day,month,year









# No Codecheck, não chame nenhuma função: o sistema trata disso.
