class FoodRatings {
private:
    unordered_map<string, pair<string, int>> foodInfo;
    unordered_map<string, set<pair<int, string>>> cuisineMap;

public:
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        int n = foods.size();
        for (int i = 0; i < n; i++) {
            string food = foods[i];
            string cuisine = cuisines[i];
            int rating = ratings[i];
            foodInfo[food] = {cuisine, rating};
            cuisineMap[cuisine].insert({-rating, food});
        }
    }
    
    void changeRating(string food, int newRating) {
        auto it = foodInfo.find(food);
        if (it == foodInfo.end()) return;
        string cuisine = it->second.first;
        int oldRating = it->second.second;
        // Remove the old entry from cuisineMap
        cuisineMap[cuisine].erase({-oldRating, food});
        // Update the rating in foodInfo
        foodInfo[food] = {cuisine, newRating};
        // Insert the new entry
        cuisineMap[cuisine].insert({-newRating, food});
    }
    
    string highestRated(string cuisine) {
        if (cuisineMap.find(cuisine) == cuisineMap.end() || cuisineMap[cuisine].empty()) {
            return "";
        }
        return cuisineMap[cuisine].begin()->second;
    }
};

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings* obj = new FoodRatings(foods, cuisines, ratings);
 * obj->changeRating(food,newRating);
 * string param_2 = obj->highestRated(cuisine);
 */