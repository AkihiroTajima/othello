board = [[2]*8 for i in range(8)]
check = []

board[3][3] = 0
board[3][4] = 1
board[4][3] = 1
board[4][4] = 0

p = 0

def plot(r,c,p,board):

        board[r][c] = p
        return board

def plot_check(r,c,p,board):

    check = []

    if not 0 <= r <= 7 or not 0 <= c <= 7:
        check.append(0)
        return check

    if board[r][c] != 2:
        check.append(0)
        return check

#ue
    try:
        if board[r-1][c] != p:

            i = 0

            while(True):

                i += 1

                if board[r-i][c] == 2:
                    check.append(0)
                    break
                elif board[r-i][c] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#shita
    try:
        if board[r+1][c] != p:

            i = 0

            while(True):

                i += 1

                if board[r+i][c] == 2:
                    check.append(0)
                    break
                elif board[r+i][c] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#hidari
    try:
        if board[r][c-1] != p:

            i = 0

            while(True):

                i += 1

                if board[r][c-i] == 2:
                    check.append(0)
                    break
                elif board[r][c-i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#migi
    try:
        if board[r][c+1] != p:

            i = 0

            while(True):

                i += 1

                if board[r][c+i] == 2:
                    check.append(0)
                    break
                elif board[r][c+i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#hidariue
    try:
        if board[r-1][c-1] != p:

            i = 0

            while(True):

                i += 1

                if board[r-i][c-i] == 2:
                    check.append(0)
                    break
                elif board[r-i][c-i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#migiue
    try:
        if board[r-1][c+1] != p:

            i = 0

            while(True):

                i += 1

                if board[r-i][c+i] == 2:
                    check.append(0)
                    break
                elif board[r-i][c+i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#hidarisita
    try:
        if board[r+1][c-1] != p:

            i = 0

            while(True):

                i += 1

                if board[r+i][c-i] == 2:
                    check.append(0)
                    break
                elif board[r+i][c-i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

#migisita
    try:
        if board[r+1][c+1] != p:

            i = 0

            while(True):

                i += 1

                if board[r+i][c+i] == 2:
                    check.append(0)
                    break
                elif board[r+i][c+i] != p:
                    pass
                else:
                    check.append(1)
                    break
            else:
                check.append(0)
        else:
            check.append(0)
    except IndexError:
        check.append(0)

    return check

def reverse_stone(r,c,p,check,board):

#ue
    if check[0] == 1:

        i = 0

        while(True):

            i += 1

            if board[r-i][c] == p:
                break
            board[r-i][c] = p

#shita
    if check[1] == 1:

        i = 0

        while(True):

            i += 1

            if board[r+i][c] == p:
                break
            board[r+i][c] = p

#hidari
    if check[2] == 1:

        i = 0

        while(True):

            i += 1

            if board[r][c-i] == p:
                break
            board[r][c-i] = p

#migi
    if check[3] == 1:

        i = 0

        while(True):

            i += 1

            if board[r][c+i] == p:
                break
            board[r][c+i] = p

#hidariue
    if check[4] == 1:

        i = 0

        while(True):

            i += 1

            if board[r-i][c-i] == p:
                break
            board[r-i][c-i] = p

#migiue
    if check[5] == 1:

        i = 0

        while(True):

            i += 1

            if board[r-i][c+i] == p:
                break
            board[r-i][c+i] = p

#hidarishita
    if check[6] == 1:

        i = 0

        while(True):

            i += 1

            if board[r+i][c-i] == p:
                break
            board[r+i][c-i] = p

#migishita
    if check[7] == 1:

        i = 0

        while(True):

            i += 1

            if board[r+i][c+i] == p:
                break
            board[r+i][c+i] = p

    return board

def pass_check(p,board):

    for i in range(8):
        for j in range(8):
            if 1 in plot_check(i,j,p,board):
                return 0
    else:
        return 1

def end_check():

    p1 = []
    p2 = []

    for i in range(8):
        for j in range(8):
            if board[i][j] == 2:
                return 0

    for i in range(8):
        for j in range(8):
            if board[i][j] == 1:
                p1.append(1)
            else:
                p2.append(0)

    if len(p1) > len(p2):
        return "winnerf is p1"
    elif len(p1) == len(p2):
        return "draw"
    else:
        return "winner is p2"

#main routine
print("")
print("   0, 1, 2, 3, 4, 5, 6, 7 ")
for i in range(8):
    print(i , board[i])

while(True):

    if pass_check(p,board) == 1:
        p = p^1
    else:
        pass

    print("turn player is ",p)
    while(True):
        try:
            r = int(input("input r >> "))
            c = int(input("input c >> "))
            break
        except ValueError:
            print("error")

    check = plot_check(r,c,p,board)
    print(check)

    if 1 in check:
        board = plot(r,c,p,board)
        board = reverse_stone(r,c,p,check,board)
    else:
        print("you cant put this position")
        continue

    print("   0, 1, 2, 3, 4, 5, 6, 7 ")
    for i in range(8):
        print(i , board[i])

    if end_check() == 0:
        pass
    else:
        print (end_check())
        break

    p = 1^p
