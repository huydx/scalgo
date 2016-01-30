import Data.Char

absolute2 x
  | x < 0     = 0-x
  | otherwise = x

numOfRealSolution a b c
  | a == 0 && c == 0 = 0
  | disc > 0 = 2
  | disc == 0 = 1
  | otherwise = 0
    where
    disc = b^2 - 4*a*c

data Signal = Red | Blue | Yellow

isL :: Char -> Bool
isL c = c == '1'

uppercase, lowercase :: String -> String
uppercase = map toUpper
lowercase = map toLower

capitalize :: String -> String
capitalize x =
  let capWord []     = []
      capWord (x:xs) = toUpper x : xs
  in unwords (map capWord (words x))

-- snd $fst (("Hello", 4), True)

f x = x + 3
square x = x^2
squareOfF x = square(f x)

main = do
  putStrLn "name: "
  name <- getLine
  putStrLn ("hello" ++ name)
