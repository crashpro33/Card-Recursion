  // Recursion for placing cards
	public void Deal(int col) {
		// Incrementing recursion
		int col2 = col;
		if (col == 7) {
			return;
		}
		else {
			// Using the recursive variable for how many cards per column
			for (; col < column.length; col++) {
				Card card = deck.deal();
				
				// Move kings to top (King is 12)
				if (card.getValue() == 12) {
					column[col].addToBeginning(card);
				}
				else {
					column[col].add(card);
				}
			}
		}
		// Increment the recursive variable
		col2++;
		// Recurse
		Deal(col2);
	}
  
  // Adds card to the beginning of the stack
  	public void addToBeginning(Card card) {
		card.setXY(stackX, stackY);
		cards.add(0, card);
		
		for (int i = 1; i < cards.size(); i++) {
			Card nextCard = cards.get(i);
			nextCard.addToXY(0, overlap);
		}
	}
