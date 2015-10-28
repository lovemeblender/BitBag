namespace Storage 
{
	class BitBag
	{
	private:
		unsigned int bitArray;
        	void resize(int);
	public:
		std::string decToBin();
        	void set(int);
       		int get(int);
        	void clear(int);
        	void clearAll();
        	BitBag();
		BitBag(int);
       		~BitBag();
	};
}
