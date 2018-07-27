package anagram

// IsAnagram is Validate anagram
func IsAnagram(src string, target string) bool {
	if len(src) != len(target) {
		return false
	}

	mapRune := make(map[rune]int)
	for _, rune := range src {
		mapRune[rune]++
	}

	for _, rune := range target {
		_, hasItem := mapRune[rune]
		if hasItem {
			mapRune[rune]--
			if mapRune[rune] == 0 {
				delete(mapRune, rune)
			}
		} else {
			return false
		}
	}

	return len(mapRune) == 0
}
