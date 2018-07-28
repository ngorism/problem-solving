package validparentheses

import "testing"

/*
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
*/
func TestAnagram(t *testing.T) {
	if IsAnagram("anagram", "nagaram") == false {
		t.Error("Failed")
	}

	if IsAnagram("rat", "car") == true {
		t.Error("Failed")
	}

	if IsAnagram("아나그램", "나그아램") == false {
		t.Error("Failed")
	}

	if IsAnagram("아나그램", "나나나나") == true {
		t.Error("Failed")
	}
}
