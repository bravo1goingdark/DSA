-- AND (&)
all true -> true
one false -> false

-- OR (|)
one true -> true
all false -> false

-- XOR (^)
no of ones odd -> 1
no of ones even -> 0

-- SHIFT (">>" or "<<")
    -- RIGHT SHIFT (>>) : right shift bit by x 
        n >> x --> n/2^x

    -- LEFT SHIFT(<<) : left shift bit by x
        n << x --> n * 2^x    

-- NOT (~)
    -flip the number
    -check if the number is -ve
    -if no is -ve -> 2's complement
    - else -> stop

