#include <iostream>
#include <memory>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

class ChessBoard {
public:
    enum class Color { WHITE,
        BLACK };

    class Piece {
    public:
        Piece(Color color) : color(color) {}
        virtual ~Piece() {}

        Color color;
        string color_string() const {
            if (color == Color::WHITE)
                return "white";
            else
                return "black";
        }

        /// Return color and type of the chess piece
        virtual string type() const = 0;

        virtual string shortRep() const = 0;

        /// Returns true if the given chess piece move is valid
        virtual bool valid_move(int from_x, int from_y, int to_x, int to_y) const = 0;
    };

    class King : public Piece {
    public:
        King(Color color) : Piece(color) {}

        string type() const override {
            return color_string() + " king";
        }

        string shortRep() const override {
            return std::string(1, color_string()[0]) + "_ki";
        }

        bool valid_move(int fromX, int fromY, int toX, int toY) const override{
            int dx = abs(toX - fromX);
            int dy = abs(toY - fromY);
            return (dx == 1 && dy == 1) || (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
        }
    };

    class Knight : public Piece {
    public:
        Knight(Color color) : Piece(color) {}

        string type() const override {
            return color_string() + " knight";
        }

        string shortRep() const override {
            return std::string(1, color_string()[0]) + "_kn";
        }

        bool valid_move(int fromX, int fromY, int toX, int toY) const override{
            int dx = abs(toX - fromX);
            int dy = abs(toY- fromY);
            return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
        }
    };

    ChessBoard() {
        // Initialize the squares stored in 8 columns and 8 rows:
        squares.resize(8);
        for (auto &square_column : squares)
            square_column.resize(8);
    }

    /// 8x8 squares occupied by 1 or 0 chess pieces
    vector<vector<unique_ptr<Piece>>> squares;

    /// Move a chess piece if it is a valid move.
    /// Does not test for check or checkmate.
    bool move_piece(const std::string &from, const std::string &to) {
        int from_x = from[0] - 'a';
        int from_y = stoi(string() + from[1]) - 1;
        int to_x = to[0] - 'a';
        int to_y = stoi(string() + to[1]) - 1;

        auto &piece_from = squares[from_x][from_y];
        if (piece_from) {
            if (piece_from->valid_move(from_x, from_y, to_x, to_y)) {
                cout << piece_from->type() << " is moving from " << from << " to " << to << endl;
                auto &piece_to = squares[to_x][to_y];
                if (piece_to) {
                    if (piece_from->color != piece_to->color) {
                        cout << piece_to->type() << " is being removed from " << to << endl;
                        if (auto king = dynamic_cast<King *>(piece_to.get()))
                            cout << king->color_string() << " lost the game" << endl;
                    } else {
                        // piece in the from square has the same color as the piece in the to square
                        cout << "can not move " << piece_from->type() << " from " << from << " to " << to << endl;
                        return false;
                    }
                }
                piece_to = move(piece_from);
                printBoard();
                return true;
            } else {
                cout << "can not move " << piece_from->type() << " from " << from << " to " << to << endl;
                return false;
            }
        } else {
            cout << "no piece at " << from << endl;
            return false;
        }
    }

    void printBoard() const {
        // Print column labels
        cout << "   ";
        for (char c = 'a'; c <= 'h'; ++c) {
            cout << setw(4) << c << " ";
        }
        cout << endl;

        // Print each row of the board
        for (int y = 7; y >= 0; --y) {
            // Print row number
            cout << setw(2) << (y + 1) << " ";

            // Print each cell in the row
            for (int x = 0; x < 8; ++x) {
                if (squares[x][y]) {
                    cout << setw(4) << squares[x][y]->shortRep() << " ";
                } else {
                    cout << setw(4) << "...." << " ";
                }
            }
            cout << endl;
        }
        cout << endl;
    }
};

int main() {
    ChessBoard board;

    board.squares[4][0] = make_unique<ChessBoard::King>(ChessBoard::Color::WHITE);
    board.squares[1][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);
    board.squares[6][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);

    board.squares[4][7] = make_unique<ChessBoard::King>(ChessBoard::Color::BLACK);
    board.squares[1][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);
    board.squares[6][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);

    board.printBoard();

    cout << "Invalid moves:" << endl;
    board.move_piece("e3", "e2");
    board.move_piece("e1", "e3");
    board.move_piece("b1", "b2");
    cout << endl;

    cout << "A simulated game:" << endl;
    board.move_piece("e1", "e2");
    board.move_piece("g8", "h6");
    board.move_piece("b1", "c3");
    board.move_piece("h6", "g8");
    board.move_piece("c3", "d5");
    board.move_piece("g8", "h6");
    board.move_piece("d5", "f6");
    board.move_piece("h6", "g8");
    board.move_piece("f6", "e8");
}