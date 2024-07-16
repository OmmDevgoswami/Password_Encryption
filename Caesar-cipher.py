# pylint: disable=invalid-name
# pylint: disable=missing-module-docstring

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

LOGO = '''
 ██████╗ █████╗ ███████╗███████╗ █████╗ ██████╗
██╔════╝██╔══██╗██╔════╝██╔════╝██╔══██╗██╔══██╗
██║     ███████║█████╗  ███████╗███████║██████╔╝
██║     ██╔══██║██╔══╝  ╚════██║██╔══██║██╔══██╗
╚██████╗██║  ██║███████╗███████║██║  ██║██║  ██║
 ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝

 ██████╗██╗██████╗ ██╗  ██╗███████╗██████╗
██╔════╝██║██╔══██╗██║  ██║██╔════╝██╔══██╗
██║     ██║██████╔╝███████║█████╗  ██████╔╝
██║     ██║██╔═══╝ ██╔══██║██╔══╝  ██╔══██╗
╚██████╗██║██║     ██║  ██║███████╗██║  ██║
 ╚═════╝╚═╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝
'''
print(LOGO)


def caesar_cipher(text, shift, direction="encode"):
    """
    Method to encode and decode text with a given shift number
    """
    cipher_text = ""
    if direction == "decode":
        shift *= -1
    for i in text:
        if i in alphabet:
            cipher_text += alphabet[((alphabet.index(i))+shift) % 26]
        else:
            cipher_text += i
    print(f"The {direction}d text is {cipher_text}")


while True:
    encode_or_decode = input(
        "Type 'encode' to encrypt, type 'decode' to decrypt: ").lower()
    message = input("Type your message: ").lower()
    shift_amount = int(input("Type the shift number: "))

    caesar_cipher(message, shift_amount, encode_or_decode)
    loop = int(input("Type 1 to continue, type 0 to exit: "))
    if 0 == loop:
        break

print("Game Over !! Thanks for Playing.")
