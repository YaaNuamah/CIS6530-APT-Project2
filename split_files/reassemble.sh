# Create reassembly script

#!/bin/bash
echo "Reassembling submission3.zip..."
cat assignment_part_* > submission3.zip
echo "Verifying checksum..."
sha256sum -c original_checksum.txt
if [ $? -eq 0 ]; then
    echo "Reassembly successful and verified!"
else
    echo "Warning: Checksum verification failed!"
fi
