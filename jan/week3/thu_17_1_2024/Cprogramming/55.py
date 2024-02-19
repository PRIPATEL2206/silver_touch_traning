# file 55.py
# The String to Integer (Atoi) Problem involves converting a string to an integer.
# It should handle white spaces, signs, and overflow conditions.

def my_atoi(s):
    s = s.strip()
    if not s:
        return 0

    sign = -1 if s[0] == '-' else 1
    if s[0] in ('-', '+'):
        s = s[1:]

    result = 0
    for char in s:
        if not char.isdigit():
            break
        result = result * 10 + int(char)
        if result * sign < -2**31:
            return -2**31
        elif result * sign > 2**31 - 1:
            return 2**31 - 1

    return result * sign

# Example usage
s = " -42"
result = my_atoi(s)
print(f"Converted integer: {result}")
