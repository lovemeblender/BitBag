namespace Storage
{
	class BitBag
	{
	private:
        	unsigned int bitArray;
        	char* decToBin();
        	void resize(int);
	public:
        	void set(int);
       		int get(int);
        	void clear(int);
        	void clearAll();
        	BitBag();
       		~BitBag();
	};
}
