"""

Input:
    PandQ
    PorQ
    P->Q
    P<-Q
    P<->Q

    brackets
    notP

Propositional Variables:
    P Q R S T U V W X Y Z

Properties of a well-formed formula:
    1. Single: Is this a formula with a single propositional variable? (e.g. P)
    2. Connection: If above is false, what is the logical connective? (e.g. Implication, and, or)
    3. LeftWF: Left formula from the logical connective has to be well-formed
    4. RightWF Right formula from the logical connective has to be well-formed

"""

import os

symbols = {'not': '\u00AC', 'and': '\u2227', 'or': '\u2228', '<->': '\u2194', '<-': '\u2190', '->': '\u2192',
           ' ': ''}


def formFormula(formula):
    #Place the unicode symbols
    for c in [['not','\u00AC'],['and','\u2227'],['or','\u2228'],['<->','\u2194'],['<-','\u2190'], ['->', '\u2192'], [' ','']]:
        while c[0] in formula:
            formula = formula.replace(c[0],c[1])

    #Remove all the invalid characters
    #Count the number of negations

    #Insert brackets
    letPos = [] # This is a list of positions with a propositional variable
    for i,c in enumerate(formula):
        if c in ('PQRSTUVWXYZ'):
            letPos.append(i)
    while letPos != []: #i.e. until the list is empty
        pos = letPos.pop()
        formula = formula[0:pos+1] + ')' + formula[pos+1:len(formula)] #Insert close bracket after the variable

        while formula[pos-1] == symbols['not']:
            pos -= 1
        formula = formula[0:pos] +'(' + formula[pos:len(formula)]


    return formula

def wellFormed(formula):
    #bracket balance, valid character filtering
    return True

class proposition():
    def __init__(self, formula):
        self.formula = formula #(((P)→(Q))→((P)→(R))) → ((P)→((Q)→(R)))
        self.single = False
        self.lhs = None
        self.connective = None
        self.rhs = None

        self.formFormula()
        self.findBrPairs()
        self.formalise()

    def formFormula(self):
        # Place the unicode symbols
        for c in [['not', '\u00AC'], ['and', '\u2227'], ['or', '\u2228'], ['<->', '\u2194'], ['<-', '\u2190'],
                  ['->', '\u2192'], [' ', '']]:
            while c[0] in self.formula:
                self.formula = self.formula.replace(c[0], c[1])

        # Remove all the invalid characters
        # Count the number of negations

        # Insert brackets
        letPos = []  # This is a list of positions with a propositional variable
        for i, c in enumerate(self.formula):
            if c in ('PQRSTUVWXYZ'):
                letPos.append(i)
        while letPos != []:  # i.e. until the list is empty
            pos = letPos.pop()
            self.formula = self.formula[0:pos + 1] + ')' + self.formula[pos + 1:len(self.formula)]  # Insert close bracket after the variable

            while self.formula[pos - 1] == symbols['not']:
                pos -= 1
            self.formula = self.formula[0:pos] + '(' + self.formula[pos:len(self.formula)]

        return self.formula

    def findBrPairs(self):
        bPosList = []
        self.brPosPairs = {}
        for i, c in enumerate(self.formula):
            if c == "(":
                bPosList.append(i)
            elif c == ")":
                if len(bPosList) > 0:
                    self.brPosPairs[bPosList.pop()] = i
                else: #IF THE LIST OF OPEN BRACKET IS EMPTY
                    pass #THEN NOT WELL-FORMED

        print ("Input: ", self.formula)
        print ("Parentheses Pairs: ", self.brPosPairs)

    def formalise(self):
        if len(self.brPosPairs) == 1 :
            self.lhs = self.formula
            self.single = True
        else:
            if (0 in self.brPosPairs) and self.brPosPairs[0] == (len(self.formula)-1):
                self.formula = self.formula[1:len(self.formula)]
                self.findBrPairs()
                self.formalise()
            print ("self.brPosPairs:", self.brPosPairs)
            firstBracketEndPos = self.brPosPairs[0]
            self.lhs = proposition(self.formula[1:self.brPosPairs[0]]) #Excluding the bracket..
            print ("Connective: ", self.formula[firstBracketEndPos+1])
            if (len(self.formula) >= firstBracketEndPos) and self.formula[firstBracketEndPos+1] in ['\u00AC','\u2227','\u2228','\u2194','\u2190','\u2192']:
                #if the next char is a connective, then assign it to self.connective
                self.connective = self.formula[firstBracketEndPos+1]
                #assign the rhs
                secondBracketEndPos = self.brPosPairs[firstBracketEndPos+2]
                self.rhs = proposition(self.formula[(firstBracketEndPos+3):secondBracketEndPos])

if __name__ == "__main__":

    premises = []

    file = open('sample_prop.txt', 'r')
    file = file.readlines()
    for p in file:
        premises.append(proposition(p))

    userinput = None

    while userinput != 'exit':
        for num, pr in enumerate(premises, start=1):
            print("Premise " + str(num) + ": " + str(pr.formula))

        print ("\'pr\' for premise input; \'dr\' for derivations: ")
        userinput = input()
        if userinput == "pr":
            raw_input = input("Please enter a formula for Premise "+ str(len(premises)+1) + ": ")
            if wellFormed(raw_input) == True:
                premises.append(proposition(raw_input))
            else:
                print ("Invalid Syntax.")
        elif userinput == "dr":
            pass
        else:
            print ("Invalid Syntax.")

        os.system('clear')
