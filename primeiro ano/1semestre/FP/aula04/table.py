# Show a table of the squares of the first four numbers
print("{:>s} {:>7s} {:10s}".format("n", "n²","2**n"))
for n in range (0,21):
    print("{:>d} {:>7d} {:10d}".format(n,n**2,2**n))

# Modify the program to show the squares of 1..20.  (Use the range function.)
# Also, add a column to show 2**n.  Adjust the formatting.
